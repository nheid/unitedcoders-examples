package com.unitedcoders.examples.codejam;

public class Rotate {

    static final int N = 7;
    static final int K = 3;

    /**
     * @param args
     */
    public static void main(String[] args) {

        char[][] board = { { 'R', '.', 'B', '.', 'R', '.', '.' }, { '.', '.', 'R', '.', 'B', 'B', '.' },
                { 'R', '.', 'B', '.', '.', '.', 'B' }, { 'R', '.', 'B', '.', '.', '.', '.' },
                { '.', 'R', 'B', 'B', '.', '.', '.' }, { '.', 'B', 'R', 'B', '.', '.', '.' },
                { '.', 'R', 'R', 'B', 'R', '.', '.' } };

        System.out.println("the board");
        printBoard(board);
        System.out.println("after 'rotation'");
        fakeRotate(board);
        printBoard(board);
        System.out.println("Winners");
        checkForWinner(board);

    }

    /**
     * we don't really rotate, we just push everything to the right
     * 
     * @param board
     */
    public static void fakeRotate(char[][] board) {

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] != '.') {
                    // push to right
                    int m = 1;
                    while ((j + m) < N && board[i][j + m] == '.') {
                        board[i][j + m] = board[i][j + (m - 1)];
                        board[i][j + (m - 1)] = '.';
                        m++;
                    }
                }
            }
        }
    }

    /**
     * Now we walk trough the 2dim array and check only to right, diagonal and downwards. That's enough, because we
     * start from "top left" and walk through line wise.
     * 
     * @param board
     */
    public static void checkForWinner(char[][] board) {
        boolean redWins = false;
        boolean blueWins = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {

                    // winning once is good enough
                    if (board[i][j] == 'B' && blueWins == true) {
                        break;
                    }
                    if (board[i][j] == 'R' && redWins == true) {
                        break;
                    }

                    // check to the right
                    int m = 1;
                    while (j + m < N && board[i][j + m] == board[i][j]) {
                        if (++m == K) {
                            switch (board[i][j]) {
                            case 'R':
                                redWins = true;
                                System.out.println("RED");
                                break;
                            case 'B':
                                blueWins = true;
                                System.out.println("BLUE");
                                break;
                            }
                        }
                    }

                    // check bottom
                    m = 1;
                    while (i + m < N && board[i + m][j] == board[i][j]) {
                        if (++m == K) {
                            switch (board[i][j]) {
                            case 'R':
                                redWins = true;
                                System.out.println("RED");
                                break;
                            case 'B':
                                blueWins = true;
                                System.out.println("BLUE");
                                break;
                            }
                        }
                    }

                    // check diagonal bottom
                    m = 1;
                    while (i + m < N && j + m < N && board[i + m][j + m] == board[i][j]) {
                        if (++m == K) {
                            switch (board[i][j]) {
                            case 'R':
                                redWins = true;
                                System.out.println("RED");
                                break;
                            case 'B':
                                blueWins = true;
                                System.out.println("BLUE");
                                break;
                            }
                        }
                    }

                    // check diagonal top
                    m = 1;
                    while (i - m >= 0 && j + m < N && board[i - m][j + m] == board[i][j]) {
                        if (++m == K) {
                            switch (board[i][j]) {
                            case 'R':
                                redWins = true;
                                System.out.println("RED");
                                break;
                            case 'B':
                                blueWins = true;
                                System.out.println("BLUE");
                                break;
                            }
                        }
                    }

                }

            }

        }

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");

        }

    }

}
