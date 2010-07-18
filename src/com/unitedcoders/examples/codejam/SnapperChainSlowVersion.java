package com.unitedcoders.examples.codejam;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Example of an bad implementation to the Google Code Jam: Snapper Chain problem
 * Does not perform well and will fail on larger datasets, even though the results calculated are correct.
 * 
 * Detailed explanation: http://united-coders.com/nico-heid/google-code-jam-the-snapper-chain
 * @author Nico Heid
 *
 */
public class SnapperChainSlowVersion {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		FileInputStream inFile = new FileInputStream(new File(
				"A-large.in"));
		DataInputStream in = new DataInputStream(inFile);
		FileOutputStream outFile = new FileOutputStream(new File("out.txt"));
		DataOutputStream out = new DataOutputStream(outFile);

		int cases = Integer.parseInt(in.readLine());

		for (int i = 1; i <= cases; i++) {

			String[] inputline = in.readLine().split("\\ ");
			int snapperCount = Integer.parseInt(inputline[0]);
			int snaps = Integer.parseInt(inputline[1]);

			boolean[] snapper = new boolean[snapperCount];

			for (int j = 0; j < snapperCount; j++) {
				snapper[j] = false;
			}

			// snapping
			boolean toggle = true;
			for (int j = 0; j < snaps; j++) {
				toggle = true;
				for (int k = 0; k < snapperCount; k++) {
					if(toggle == false){
						break;
					}
					if (toggle == true) {
						snapper[k] = !snapper[k];
					}
					if (snapper[k] == true) {
						toggle = false;
					}

				}
			}

			// we need power on all snappers
			boolean power = true;
			for (int j = 0; j < snapperCount; j++) {
				if (snapper[j] == false) {
					power = false;
					break;
				}
				
			}

			String result = ("Case #" + i + ": " + (power ? "ON" : "OFF"));
			System.out.println(result);
			out.writeBytes(result + "\n");

		}

	}
}
