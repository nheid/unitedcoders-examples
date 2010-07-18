package com.unitedcoders.examples.codejam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

			while (!allCombinationsFound && (rides < r)) {
				int startPosition = groupPosition;
				// start riding
				while (!allCombinationsFound && (seatsTaken + groups[groupPosition % n]) <= k && groupsInRide < n) {
					seatsTaken += groups[groupPosition % n];
					groupPosition++;
					groupsInRide++;
					
				}
				rides++;
				income+=seatsTaken;
				groupPosition = groupPosition % n;
				
				if (groupStore.get(startPosition) != null) {
					allCombinationsFound = true;
				} else {
					
					groupStore.put(startPosition, new Integer[] { groupPosition, seatsTaken });
					
				}
				//reset
				seatsTaken = 0;
				groupsInRide = 0;
			
			}
			
			// now we found all combinations, just read from the map
			while(rides < r){
				Integer[] thisRide = groupStore.get(groupPosition);
				income+=thisRide[1];
				groupPosition = thisRide[0];
				rides++;
				
			}
			

			String result = ("Case #" + i + ": " + income);
			System.out.println(result);
			out.writeBytes(result + "\n");

		}

	}

}
