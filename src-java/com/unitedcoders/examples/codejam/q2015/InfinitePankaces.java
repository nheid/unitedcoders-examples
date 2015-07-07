package com.unitedcoders.examples.codejam.q2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nheid on 15-04-11.
 */
public class InfinitePankaces {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/Downloads/B-large-practice.in";
    static String outfile = "/Users/nheid/Downloads/B-large-practice.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        new InfinitePankaces().solve();
        in.close();
        out.close();
    }

    public void solve() {

        int cases = in.nextInt();

        for (int caseNr = 1; caseNr <= cases; caseNr++) {

            System.out.print("Case #" + caseNr + ": ");
            out.print("Case #" + caseNr + ": ");

            int diners = in.nextInt();
            int max = 0;
            List<Integer> plates = new ArrayList<>();
            for (int i = 0; i < diners; i++) {
                int cakes = in.nextInt();
                plates.add(cakes);
            }

            int result = checkPlates(plates);

            System.out.println(result);
            out.println(result);
        }
    }

    private int checkPlates(List<Integer> plates) {
        int max = Integer.MAX_VALUE;
        int fullestPlate = plates.stream().max(Integer::compare).get();

        for (int i = 1; i <= fullestPlate; i++) {
            int moves = 0;
            for (int p : plates) {
                if (p > i) {
                    moves += p / i;
                    if (p % i == 0) {
                        moves--;
                    }
                }
            }

            if (moves + i < max) {
                max = moves + i;
            }
        }

        return max;
    }

}
