package com.unitedcoders.examples.codejam.q2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class StandingOvation {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/Downloads/A-large.in";
    static String outfile = "/Users/nheid/Downloads/A-large.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        new StandingOvation().solve();
        in.close();
        out.close();
    }

    public void solve() {

        int cases = in.nextInt();

        for (int j = 1; j <= cases; j++) {
            System.out.print("Case #" + j + ": ");
            out.print("Case #" + j + ": ");

            int maxShyness = in.nextInt();
            String crowd = in.next();

            int sum = 0;
            int friends = 0;
            for (int i = 0; i <= maxShyness; i++) {
                int pos = Character.getNumericValue(crowd.charAt(i));

                if (sum < i) {
                    friends += (i - sum);
                    sum += (i - sum);
                }
                sum+=pos;
            }

            System.out.println(friends);
            out.println(friends);


        }

    }

}
