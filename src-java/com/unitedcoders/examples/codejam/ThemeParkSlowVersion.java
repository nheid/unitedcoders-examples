package com.unitedcoders.examples.codejam;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Example of an slow implementation to the Google Code Jam: Theme Park
 * 
 * Detailed explanation: http://united-coders.com/nico-heid/google-code-jam-the-snapper-chain
 * @author Nico Heid
 *
 */
public class ThemeParkSlowVersion {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub

		FileInputStream inFile = new FileInputStream(new File("resources/codejam/ThemePark.in"));
		DataInputStream in = new DataInputStream(inFile);
		FileOutputStream outFile = new FileOutputStream(new File("out.txt"));
		DataOutputStream out = new DataOutputStream(outFile);
		
		
		int cases = Integer.parseInt(in.readLine());
		
		long starttime = new Date().getTime();

		for (int i = 1; i <= cases; i++) {
			
			String[] input = in.readLine().split("\\ ");
			int r = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			long n = Integer.parseInt(input[2]);
			
			long[] groups = new long[(int) n];
			
			// groups
			input = in.readLine().split("\\ ");
			for(int j=0; j<input.length; j++){
				groups[j] = Integer.parseInt(input[j]);
				
			}
			
			// group pointer
			long g = 0;
			
			int income = 0;
			
			// rides
			for(int j=1; j<=r; j++ ){
				// we can fill the coaster with max all groups (nobody can be present twice)
				int groupRotation = 0;
				
				// fill rollercoaster
				int seatsTaken = 0;
				
				while(( seatsTaken + groups[(int) (g % n)]) <= k && (groupRotation < n)){
					// seats free
					seatsTaken +=  groups[(int) (g % n)];
					g++;
					groupRotation++;
				}
			
				// rollercoaster starting
				income += seatsTaken;
			}
			
			
			String result = ("Case #" + i + ": "+ income );
			System.out.println(result);
			out.writeBytes(result +"\n");
			
			
			
		}
		
		System.out.println("Time: "+ (new Date().getTime() - starttime) /1000);

	}

}
