package com.unitedcoders.examples.codejam.q2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by nheid on 15-04-11.
 */
public class OminousOmino {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/Downloads/D-large.in";
    static String outfile = "/Users/nheid/Downloads/D-large.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        new OminousOmino().solve();
        in.close();
        out.close();
    }

    public void solve() {


        int cases = in.nextInt();

        for (int caseNr = 1; caseNr <= cases; caseNr++) {

            System.out.print("Case #" + caseNr + ": ");
            out.print("Case #" + caseNr + ": ");

            int x = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();

            boolean richard = false;

            if ((r * c) % x != 0) {
                richard = true;
            } else {
                richard = false;
                for (int i = 1; i < x; i++) {
                    if (i > r || i > c) {
                        richard = true;
                    }
                }


            }

            if (richard) {
                System.out.println("RICHARD");
                out.println("RICHARD");
            } else {
                System.out.println("GABRIEL");
                out.println("GABRIEL");
            }

        }

    }


}
