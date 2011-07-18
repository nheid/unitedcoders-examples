package com.unitedcoders.examples.codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SpaceEmergency {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("B-small-practice.in"));
        PrintStream out = new PrintStream(new File("space.out"));
        int testcases = scanner.nextInt();

        // we multiply distances and speed with two so we don't have floats
        // this means regular speed is 1, boosted speed is 2

        for (int casenr = 1; casenr <= testcases; casenr++) {

            Integer time = 0;
//            Integer position = 0;
            Integer boosters = scanner.nextInt();       // L
            long buildTime = scanner.nextLong();      // t
            Integer finalStar = scanner.nextInt();      // N
            Integer stars = scanner.nextInt();          // C
            List<Integer> distances = new ArrayList<Integer>();
            for (int i = 0; i < stars; i++) {
                distances.add(scanner.nextInt() * 2);
            }

            // lay out the track we'll travel
            List<Integer> track = new ArrayList<Integer>();
            for (int i = 0; i < finalStar; i++) {
                track.add(distances.get(i % distances.size()));
            }


            // let the ship fly till the boosters are ready
            while (track.size()>0 && track.get(0) <= buildTime) {
                time += track.get(0);
                buildTime -= track.get(0);
                track.remove(0);

            }
            // check if we're between two planets when the boosters are ready
            if (track.size() > 0 && buildTime > 0) {
                time += (int) buildTime;
                track.set(0, track.get(0) - (int)buildTime);
            }

            // reorder by distance use boosters on longest distance until we're out of boosters
            Collections.sort(track);
            Collections.reverse(track);

            while (track.size() > 0) {
                if (boosters > 0) {
                    time += track.get(0) / 2;
                    track.remove(0);
                    boosters--;
                } else {
                    time += track.get(0);
                    track.remove(0);
                }


            }

            System.out.printf("Case #%d: %s\n", casenr, time);
            out.printf("Case #%d: %s\n", casenr, time);

        }

    }

}


