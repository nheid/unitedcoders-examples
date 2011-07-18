package com.unitedcoders.examples.codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SpaceEmergency {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("B-large-practice.in"));
        PrintStream out = new PrintStream(new File("space.out"));
        int testcases = scanner.nextInt();

        // we multiply distances and speed with two so we don't have floats
        // this means regular speed is 1, boosted speed is 2

        for (int casenr = 1; casenr <= testcases; casenr++) {

            long time = 0;
            Integer position = 0;
            Integer starsPassed = 0;
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
            while (position < finalStar && track.get(position) <= buildTime) {
                time += track.get(position);
                buildTime -= track.get(position);
                position++;
                starsPassed++;

            }
            // check if we're between two planets when the boosters are ready
            if (position < finalStar && buildTime > 0) {
                time += (int) buildTime;
                track.set(position, track.get(position) - (int) buildTime);
            }

            track = track.subList(starsPassed, track.size());
            finalStar -= starsPassed;
            position = 0;

            // reorder by distance use boosters on longest distance until we're out of boosters
            Collections.sort(track);
            Collections.reverse(track);

            while (position < finalStar) {
                if (boosters > 0) {
                    time += track.get(position) / 2;
                    position++;
                    boosters--;
                } else {
                    time += track.get(position);
                    position++;
                }


            }

            System.out.printf("Case #%d: %s\n", casenr, time);
            out.printf("Case #%d: %s\n", casenr, time);

        }

    }

}


