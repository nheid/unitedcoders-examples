package com.unitedcoders.examples.codejam.q2015;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by nheid on 15-04-11.
 */
public class Dijkstra {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/Downloads/C-small-attempt1.in";
    //    static String infile = "/Users/nheid/Downloads/B-small.in";
    static String outfile = "/Users/nheid/Downloads/C-small1.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        new Dijkstra().solve();
        in.close();
        out.close();
    }

    public void solve() {

        int cases = in.nextInt();

        for (int caseNr = 1; caseNr <= cases; caseNr++) {

            System.out.print("Case #" + caseNr + ": ");
            out.print("Case #" + caseNr + ": ");

            int nrOfLetters = in.nextInt();
            int reps = in.nextInt();
            String letters = in.next();

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < reps; i++) {
                sb.append(letters);
            }

            String misspelled = sb.toString();

            while (misspelled.length() > 3) {

                for (int i = 0; i < misspelled.length() - 1; i++) {
                    String replaced = reduce(misspelled.substring(0, 2));
                    misspelled = replaced + misspelled.substring(2, misspelled.length());
                    if (replaced.equals("i")) {
                        misspelled = "i" + misspelled;
                        break;
                    }
                }
                for (int i = 0; i < misspelled.length() - 2; i++) {
                    String replaced = reduce(misspelled.substring(1, 3));
                    misspelled = replaced + misspelled.substring(3, misspelled.length());
                    if (replaced.equals("j")) {
                        misspelled = "j" + misspelled;
                        break;
                    }
                }
                for (int i = 0; i < misspelled.length() - 3; i++) {
                    String replaced = reduce(misspelled.substring(2, 4));
                    misspelled = replaced + misspelled.substring(4, misspelled.length());
                    if (replaced.equals("k")) {
                        misspelled = "kccccccdugcdrerlicnbhvdervibfinbcuhrrgfbitrdu" +
                                "" + misspelled;
                        break;
                    }
                }
            }


        System.out.print(misspelled + " ");

        if (misspelled.equals("ijk")) {
            System.out.println("YES");
            out.println("YES");
        } else {
            System.out.println("NO");
            out.println("NO");
        }

    }

}

    private String reduce(String input) {
        switch (input) {
            case "11":
                return "1";
            case "1i":
                return "i";
            case "1j":
                return "j";
            case "1k":
                return "k";

            case "i1":
                return "i";
            case "ii":
                return "1";
            case "ij":
                return "k";
            case "ik":
                return "j";

            case "j1":
                return "j";
            case "ji":
                return "k";
            case "jj":
                return "1";
            case "jk":
                return "i";

            case "k1":
                return "k";
            case "ki":
                return "j";
            case "kj":
                return "i";
            case "kk":
                return "1";

            default:
                throw new IllegalStateException();
        }
    }

}
