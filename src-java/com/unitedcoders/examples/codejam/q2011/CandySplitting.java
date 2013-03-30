package com.unitedcoders.examples.codejam.q2011;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CandySplitting {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nh/Downloads/C-small-practice.in";
    static String outfile = "/Users/nh/Downloads/C-small-practice.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);

        int cases = in.nextInt();
        int solution = -1;

        for (int j = 1; j <= cases; j++) {
            solution = -1;

            int candyPieces = in.nextInt();
            List<Integer> candy = new ArrayList<Integer>(candyPieces);

            for (int i = 0; i < candyPieces; i++) {
                candy.add(in.nextInt());
            }

            List<List<Integer>> sets = powerSet(candy);

            Iterator it = sets.iterator();
            List<Integer> staple1 = null;
            while (it.hasNext()) {
                List<Integer> staple2 = new ArrayList<Integer>();
                staple1 = (List<Integer>) it.next();

                if (staple1.size() == candy.size()) {
                    continue;
                }

                for (int k : candy) {
                    staple2.add(k);
                }

                for (int k : staple1) {
                    if (staple2.contains(k)) {
                        staple2.remove((Object) k);
                    }
                }

                if (sumPatrick(staple1) == sumPatrick(staple2)) {
                    if (sumSeam(staple1) > solution) {
                        solution = sumSeam(staple1);
                    }
                }
            }
            System.out.println("Case #" + j + ": " + ((solution == -1) ? "NO" : solution));
            out.println("Case #" + j + ": " + ((solution == -1) ? "NO" : solution));
        }

        in.close();
        out.close();
    }

    public static int sumPatrick(List<Integer> candy) {
        int sum = 0;
        for (int i : candy) {
            sum = sum ^ i;
        }
        return sum;
    }

    public static int sumSeam(List<Integer> candy) {
        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }


    public static List<List<Integer>> powerSet(List<Integer> originalSet) {
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        List<Integer> rest = new ArrayList<Integer>(list.subList(1, list.size()));
        for (List<Integer> set : powerSet(rest)) {
            List<Integer> newSet = new ArrayList<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

}
