package com.example.varun.a4inarow;

/**
 * Created by ${Varun} on ${3/27/2016}.
 */

class Board {

    private int player;
    private int[][] gameBoard = new int[][] {
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}
    };

    private int positionBoard[][] = new int[][] {
            {1,2,3,4,5,6,7},
            {8,9,10,11,12,13,14},
            {15,16,17,18,19,20,21},
            {22,23,24,25,26,27,28},
            {29,30,31,32,33,34,35},
            {36,37,38,39,40,41,42},
    };

    Board() {
        player = 1;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayers(int currentPlayer) {
        if (currentPlayer == 1) { player = 2; }
        if (currentPlayer == 2) { player = 1; }
    }


    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int[][] getPositionBoard() {
        return positionBoard;
    }

    public void setGameBoard(int[][] a) { gameBoard = a; }

    public boolean fullBoard() {
        int emptyCircles = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (gameBoard[i][j] == 0) {
                    emptyCircles++;
                }
            }
        }
        if (emptyCircles == 0) { return true; }
        else { return false;}
    }

    public void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                gameBoard[i][j] = 0;
            }
        }
    }


    public int verticalWinner() {
        int count1, count2, winner = 0;
        int previous;
        for (int i = 0; i < 7; i++) {
            count1 = 0;
            count2 = 0;
            previous = gameBoard[5][i];
            for (int j = 5; j >= 0; j--) {
                // player 1 and player 2
                if (gameBoard[j][i] == 1) {
                    if (previous == 1 || (previous != 1 && count1 == 0)) {
                        count1++;
                        count2 = 0;
                    }
                } else if (gameBoard[j][i] == 2) {
                    if (previous == 2 || (previous != 2 && count2 == 0)) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = gameBoard[j][i];
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }
        return winner;
    }

    public int horizontalWinner() {
        int count1, count2, winner = 0;
        int previous;

        for (int i = 5; i >= 0; i--) {
            count1 = 0;
            count2 = 0;
            previous = gameBoard[i][0];
            for (int j = 0; j < 7; j++) {
                if (gameBoard[i][j] == 1) {
                    if (previous == 1 || (previous != 1 && count1 == 0)) {
                        count1++;
                        count2 = 0;
                    }
                } else if (gameBoard[i][j] == 2) {
                    if (previous == 2 || (previous != 2 && count2 == 0)) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = gameBoard[i][j];
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }
        return winner;
    }

    public int diagonalWinner1() {
        // two separate bodies for checking diagonals
        // first diagonal check
        int count1, count2, winner = 0, previous;
        // first half of the board
        for (int i = 0; i < 6; i++) {
            count1 = 0;
            count2 = 0;
            int j = i, k = 0;
            previous = gameBoard[i][0];
            while (j >= 0) {
                if (gameBoard[j][k] == 1) {
                    if (previous == 1 || (previous != 1 && count1 == 0)) {
                        count1++;
                        count2 = 0;
                    }
                }

                if (gameBoard[j][k] == 2) {
                    if (previous == 2 || (previous != 2 && count2 == 0)) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = gameBoard[j][k];
                j--;
                k++;
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }

        // second half of the board
        if (winner == 0) {
            for (int i = 1; i < 7; i++) {
                count1 = 0;
                count2 = 0;
                previous = gameBoard[5][i];
                int j = 5, k = i;
                while (k < 7) {
                    if (gameBoard[j][k] == 1) {
                        if (previous == 1 || (previous != 1 && count1 == 0)) {
                            count1++;
                            count2 = 0;
                        }
                    }

                    if (gameBoard[j][k] == 2) {
                        if (previous == 2 || (previous != 2 && count2 == 0)) {
                            count2++;
                            count1 = 0;
                        }
                    }
                    previous = gameBoard[j][k];
                    j--;
                    k++;
                    if (count1 >= 4) {
                        winner = 1;
                    }
                    if (count2 >= 4) {
                        winner = 2;
                    }
                }
            }
        }

        return winner;
    }

    public int diagonalWinner2() {
        int count1, count2, winner = 0, previous;

        for (int i = 0; i < 6; i++) {
            count1 = 0;
            count2 = 0;
            previous = gameBoard[i][6];
            int j = i, k = 6;
            while (j >= 0) {
                if (gameBoard[j][k] == 1) {
                    if (previous == 1 || (previous != 1 && count1 == 0)) {
                        count1++;
                        count2 = 0;
                    }
                }

                if (gameBoard[j][k] == 2) {
                    if (previous == 2 || (previous != 2 && count2 == 0)) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = gameBoard[j][k];
                j--;
                k--;
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }

        // second half of board
        if (winner == 0) {
            for (int i = 5; i >= 0; i--) {
                count1 = 0;
                count2 = 0;
                previous = gameBoard[5][i];
                int j = 5, k = i;
                while (k >= 0) {
                    if (gameBoard[j][k] == 1) {
                        if (previous == 1 || (previous != 1 && count1 == 0)) {
                            count1++;
                            count2 = 0;
                        }
                    }

                    if (gameBoard[j][k] == 2) {
                        if (previous == 2 || (previous != 2 && count2 == 0)) {
                            count2++;
                            count1 = 0;
                        }
                    }
                    previous = gameBoard[j][k];
                    j--;
                    k--;
                    if (count1 >= 4) {
                        winner = 1;
                    }
                    if (count2 >= 4) {
                        winner = 2;
                    }
                }
            }
        }

        return winner;
    }
}
