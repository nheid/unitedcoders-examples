package com.unitedcoders.examples.codejam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class ThemePark {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		FileInputStream inFile = new FileInputStream(new File("resources/codejam/ThemePark.in"));
		DataInputStream in = new DataInputStream(inFile);
		FileOutputStream outFile = new FileOutputStream(new File("resources/codejam/ThemePark.out"));
		DataOutputStream out = new DataOutputStream(outFile);

		int cases = Integer.parseInt(in.readLine());

		long startTime = new Date().getTime();
		// doSmallSteps(cases, in, out);
		doBigSteps(cases, in, out);
		System.out.println("Calculation took: " + (new Date().getTime() - startTime) / 1000 + " seconds");

	}

	/**
	 * The slower step by step iterating of the map
	 * 
	 * @param cases
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void doSmallSteps(int cases, DataInputStream in, DataOutputStream out) throws IOException {

		for (int i = 1; i <= cases; i++) {

			String[] input = in.readLine().split("\\ ");
			int r = Integer.parseInt(input[0]); // rides
			int k = Integer.parseInt(input[1]); // seats
			int n = Integer.parseInt(input[2]); // nr of groups

			int[] groups = new int[n]; // groups for this case

			// groups
			input = in.readLine().split("\\ ");
			for (int j = 0; j < input.length; j++) {
				groups[j] = Integer.parseInt(input[j]);

			}

			long income = 0;
			int groupPosition = 0;
			int seatsTaken = 0;
			int rides = 0;
			int groupsInRide = 0;

			// start position, and in array end position [0] and income[1]
			Map<Integer, Integer[]> groupStore = new HashMap<Integer, Integer[]>();

			boolean allCombinationsFound = false;

			// find all combinations, while doing so also calculate the income
			// and rides
			while (!allCombinationsFound && (rides < r)) {
				int startPosition = groupPosition;
				// start riding
				while (!allCombinationsFound && (seatsTaken + groups[groupPosition % n]) <= k && groupsInRide < n) {
					seatsTaken += groups[groupPosition % n];
					groupPosition++;
					groupsInRide++;

				}
				rides++;
				income += seatsTaken;
				groupPosition = groupPosition % n;

				if (groupStore.get(startPosition) != null) {
					allCombinationsFound = true;
				} else {

					groupStore.put(startPosition, new Integer[] { groupPosition, seatsTaken });

				}
				// reset
				seatsTaken = 0;
				groupsInRide = 0;

			}

			// now we found all combinations, just read from the map
			while (rides < r) {
				Integer[] thisRide = groupStore.get(groupPosition);
				income += thisRide[1];
				groupPosition = thisRide[0];
				rides++;

			}

			String result = ("Case #" + i + ": " + income);
			System.out.println(result);
			out.writeBytes(result + "\n");

		}

	}

	/**
	 * The faster cycle detection.
	 * 
	 * @param cases
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void doBigSteps(int cases, DataInputStream in, DataOutputStream out) throws IOException {
		for (int i = 1; i <= cases; i++) {

			String[] input = in.readLine().split("\\ ");
			int r = Integer.parseInt(input[0]); // rides
			int k = Integer.parseInt(input[1]); // seats
			int n = Integer.parseInt(input[2]); // nr of groups

			int[] groups = new int[n]; // groups for this case

			// groups
			input = in.readLine().split("\\ ");
			for (int j = 0; j < input.length; j++) {
				groups[j] = Integer.parseInt(input[j]);

			}

			long income = 0;
			int endPosition = 0;
			int seatsTaken = 0;
			int rides = 0;
			int groupsInRide = 0;

			// start position, and in array end position [0] and income[1]
			Map<Integer, Integer[]> groupStore = new HashMap<Integer, Integer[]>();

			int startPosition = -1;

			// find all combinations, while doing so also calculate the income
			// and rides
			while (rides < r) {
				startPosition = endPosition;
				if (groupStore.get(startPosition) != null) {
					break;
				}

				// start riding
				while ((seatsTaken + groups[endPosition % n]) <= k && groupsInRide < n) {
					seatsTaken += groups[endPosition % n];
					endPosition++;
					groupsInRide++;

				}
				rides++;
				income += seatsTaken;
				endPosition = endPosition % n;

				groupStore.put(startPosition, new Integer[] { endPosition, seatsTaken });

				// reset
				seatsTaken = 0;
				groupsInRide = 0;

			}

			// now we found all combinations, we're trying to calculate the big cycle
			int cycleEndPosition = startPosition;
			long incomeFullCycle = 0;
			int cycleRideCount = 0;
			do {
				Integer[] curPos = groupStore.get(cycleEndPosition);
				cycleEndPosition = curPos[0];
				incomeFullCycle += curPos[1];
				cycleRideCount++;
			} while (endPosition != cycleEndPosition);

			int ridesLeft = r - rides;
			int fullCycles = ridesLeft / cycleRideCount;
			income += fullCycles * incomeFullCycle;
			rides += cycleRideCount * fullCycles;

			// the last rides is step by step again;
			while (rides < r) {
				Integer[] thisRide = groupStore.get(endPosition);
				income += thisRide[1];
				endPosition = thisRide[0];
				rides++;

			}

			String result = ("Case #" + i + ": " + income);
			System.out.println(result);
			out.writeBytes(result + "\n");

		}

	}

}
