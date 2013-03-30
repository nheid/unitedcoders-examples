package com.unitedcoders.examples.codejam.q2011;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class CandySplittingImproved {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nh/Downloads/C-large-practice.in";
    static String outfile = "/Users/nh/Downloads/C-large-practice.out";

public static void main(String[] args) throws FileNotFoundException {
    in = new Scanner(new FileReader(infile));
    out = new PrintWriter(outfile);

    int cases = in.nextInt();

    for (int j = 1; j <= cases; j++) {
        int candyPieces = in.nextInt();
        List<Integer> candy = new ArrayList<Integer>(candyPieces);


        for (int i = 0; i < candyPieces; i++) {
            candy.add(in.nextInt());
        }
        int xorResult = candy.get(0);
        for (int k = 1; k < candy.size(); k++) {
            xorResult = xorResult ^ candy.get(k);
        }

        // there is a solution if xor == 0
        String result = "NO";
        if (xorResult == 0) {
            candy.remove(Collections.min(candy));
            result = String.valueOf(sumList(candy));
        }

        System.out.println("Case #" + j + ": " + result);
        out.println("Case #" + j + ": " + result);
    }

    in.close();
    out.close();
}

public static int sumList(List<Integer> candy) {
    int sum = 0;
    for (int i : candy) {
        sum += i;
    }
    return sum;
}
}
