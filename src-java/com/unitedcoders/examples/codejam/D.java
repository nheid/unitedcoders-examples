package com.unitedcoders.examples.codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class D {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/projects/unitedcoders-examples/resources/codejam/A-small.in";
    static String outfile = "/Users/nheid/projects/unitedcoders-examples/resources/codejam/A-small.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);

        new D().solve();

        in.close();
        out.close();
    }

    private void solve() {

        int cases = in.nextInt();

        for (int j = 1; j <= cases; j++) {
            System.out.print("Case #" + j + ": ");
            out.print("Case #" + j + ": ");
        }


        System.out.println("");
        out.println("");

    }

}
