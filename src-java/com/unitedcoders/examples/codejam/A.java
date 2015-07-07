package com.unitedcoders.examples.codejam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class A {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nheid/downloads/A-small-attempt6.in";
    static String outfile = "/Users/nheid/downloads/A-small-attempt6.out";
//    static String infile = "/Users/nheid/downloads/A-small.in";
//    static String outfile = "/Users/nheid/downloads/A-small.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);

        new A().solve();

        in.close();
        out.close();
    }

    private void solve() {

        int cases = in.nextInt();

        for (int j = 1; j <= cases; j++) {

            System.out.print("Case #" + j + ": ");
            out.print("Case #" + j + ": ");


            long target = in.nextLong();
            long nr = 1;
            int counter = 1;

            do{
                if(nr==target){
                    break;
                }
                long nextNr = nr + 1;
                long reversedNr = reverse(nr);
                long reversedNextNr = reverse(nr + 1);
                if (reversedNr == target) {
                    nr = reversedNr;
                } else if (reversedNr < target && reversedNextNr > target && reversedNr > nr) {
                    nr = reversedNr;
                } else if (reversedNr <= target && reversedNextNr < reversedNr && reversedNr > nr) {
                    nr = reversedNr;
                } else{
                    nr++;
                }
                counter++;


            }while (nr != target);


            System.out.println(counter);
            out.println(counter);
        }

    }

    private long reverse(long nr) {
        return Long.parseLong(new StringBuilder(String.valueOf(nr)).reverse().toString());
    }

}
