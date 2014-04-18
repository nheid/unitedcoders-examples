package com.unitedcoders.examples.codejam.q2014;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class MagicTrick {

    private static Scanner in;
    private static PrintWriter out;
    static String infile = "/Users/nh/Downloads/A-small-practice.in";
    static String outfile = "/Users/nh/Downloads/A-small-practice.out";

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new FileReader(infile));
        out = new PrintWriter(outfile);
        new MagicTrick().solve();
        in.close();
        out.close();
    }

    public void solve() {

        int cases = in.nextInt();

        for (int j = 1; j <= cases; j++) {
            out.print("Case #" + j + ": ");

            // first card
            int rowWithCard = in.nextInt();
            in.nextLine();
            List<String> row1 = getRow(rowWithCard);

            //second card
            rowWithCard = in.nextInt();
            in.nextLine();
            List<String> row2 = getRow(rowWithCard);

            if (!isWizardWithoutFailure(row1, row2)) {
                out.println("Bad Magician!");
                continue;
            }

            String result = findCard(row1, row2);
            if (result == null) {
                out.println("Volunteer cheated!");
                continue;
            } else {
                out.println(result);
            }
        }
    }


    // get the card from the chosen row, every other row is not interesting
    private List<String> getRow(int chosenRow) {
        List<String> cardRow = new ArrayList();
        for (int row = 1; row <= 4; row++) {
            if (chosenRow == row) {
                cardRow.addAll(Arrays.asList(in.nextLine().split(" ")));
            } else {
                in.nextLine();
            }
        }
        return cardRow;
    }

    // check if the wizard did lay down less than two cards from the previous row picked by the volunteer
    private boolean isWizardWithoutFailure(List<String> row1, List<String> row2) {
        int matchingCards = 0;

        for (String card : row1) {
            if (row2.contains(card)) {
                matchingCards++;
            }
        }
        if (matchingCards > 1) {
            return false;
        }

        return true;
    }

    // find the duplicate card, if there is none, volunteer cheated
    private String findCard(List<String> row1, List<String> row2) {
        for (String card : row1) {
            if (row2.contains(card)) {
                return card;
            }
        }

        return null;
    }


}
