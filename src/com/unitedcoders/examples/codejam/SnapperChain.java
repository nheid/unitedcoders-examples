package com.unitedcoders.examples.codejam;

/**
 * Example solution of the Google Code Jam: Snapper Chain problem
 * Detailed explanation: http://united-coders.com/nico-heid/google-code-jam-the-snapper-chain
 * @author Nico Heid
 *
 */
public class SnapperChain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// snappers
		int n=4;
		// snaps
		int k=47;
		
		String needed = Integer.toBinaryString((1<<n)-1);
		String current = Integer.toBinaryString(47);
		
//		System.out.println("state needed : "+ needed);
//		System.out.println("current state: "+ current );
//		System.out.println("result of AND: "+ Integer.toBinaryString(k & (1<<n)-1) );

	
		System.out.println((((k+1)>>n)<<n) == (k+1) ? "on" : "off");
	
	}

}
