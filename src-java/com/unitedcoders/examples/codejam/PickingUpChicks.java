package com.unitedcoders.examples.codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class PickingUpChicks {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/nheid/tmp/largechicken.in")));

        int testcases = Integer.parseInt(reader.readLine());
        for (int casenr = 1; casenr <= testcases; casenr++) {

            String[] info = reader.readLine().split(" ");

            int chicksTotal = Integer.parseInt(info[0]);
            int chicksNeedToFinish = Integer.parseInt(info[1]);
            int barnPosition = Integer.parseInt(info[2]);
            int time = Integer.parseInt(info[3]);

            int[] startPosition = convertStringArraytoIntArray(reader.readLine().split(" "));
            int[] speed = convertStringArraytoIntArray(reader.readLine().split(" "));

            String result = solve(startPosition, speed, barnPosition, time, chicksNeedToFinish);
            System.out.printf("Case #%d: %s\n", casenr, result);


        }
    }

    public static String solve(int[] startposition, int[] speed, int barnPosition, int time, int chicksNeedToFinish) {

        int finishers = 0;
        boolean[] isFastEnough = new boolean[startposition.length];

        for (int i = 0; i < startposition.length; i++) {
            if ((startposition[i] + speed[i] * time) >= barnPosition) {
                isFastEnough[i] = true;
                finishers++;
            } else {
                isFastEnough[i] = false;
            }
        }

        if (finishers < chicksNeedToFinish) {
            return "IMPOSSIBLE";
        }

        // start from closest to barn to furthest swap speedy chicken until we have the required number
        finishers = 0;
        int position = startposition.length - 1;
        int priceOfSwap = 0;
        int swaps = 0;
        for (int i = startposition.length - 1; i >= 0; i--) {

            if (isFastEnough[i]) {
                finishers++;
                if (priceOfSwap > 0) {
                    swaps += priceOfSwap;
                }
            } else {
                priceOfSwap++;
            }

            if (chicksNeedToFinish == finishers) {
                return String.valueOf(swaps);
            }

        }

        return "MY LOGIC IS WRONG";

    }


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