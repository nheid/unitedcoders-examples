package com.unitedcoders.examples.codejam;


import java.io.*;

public class LoadTesting {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/nheid/Downloads/LoadTesting.in")));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/nheid/Downloads/LoadTesting.out")));


        int cases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < cases; i++) {

            String[] values = reader.readLine().split(" ");
            int l = Integer.parseInt(values[0]);
            int p = Integer.parseInt(values[1]);
            int c = Integer.parseInt(values[2]);

            int loadtests = 0;

            while (l < p) {
                l *= c;
                loadtests++;

            }

            loadtests = 32 - Integer.numberOfLeadingZeros(loadtests - 1);

            System.out.println("Case #" + (i + 1) + ": " + loadtests);
            writer.write("Case #" + (i + 1) + ": " + loadtests + "\n");

        }

        reader.close();
        writer.close();


    }
}
