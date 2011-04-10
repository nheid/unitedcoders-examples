package com.unitedcoders.examples.codejam;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class MinimumScalarProduct {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("resources/codejam/msp-large.in")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resources/codejam/msp.out")));

        int cases = Integer.parseInt(reader.readLine());
        int values;

        for (int i = 0; i < cases; i++) {

            values = Integer.parseInt(reader.readLine());
            String[] xs = reader.readLine().split(" ");
            String[] ys = reader.readLine().split(" ");
            int[] x = convertStringArraytoIntArray(xs);
            int[] y = convertStringArraytoIntArray(ys);

            BigInteger result = getMinimumScalarProduct(x,y);

            System.out.printf("Case #%d: %s\n", i + 1, result.toString());
            writer.write("Case #" + (i + 1) + ": " + result.toString() + "\n");

        }

        reader.close();
        writer.close();

    }


    public static BigInteger getMinimumScalarProduct(int[] x, int[] y) {

        Arrays.sort(x);
        Arrays.sort(y);
//        y = reverse(y);

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < x.length; i++) {
            sum = sum.add( new BigInteger(""+ x[i]).multiply(new BigInteger(""+y[x.length -1 -i])));
        }

        return sum;


    }

//    public static int[] reverse(int[] array) {
//
//        int[] result = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            result[i] = array[array.length - 1 - i];
//        }
//        return result;
//    }


    public static int[] convertStringArraytoIntArray(String[] sarray) throws Exception {
        if (sarray != null) {
            int intarray[] = new int[sarray.length];
            for (int i = 0; i < sarray.length; i++) {
                intarray[i] = Integer.parseInt(sarray[i]);
            }
            return intarray;
        }
        return null;
    }
}
