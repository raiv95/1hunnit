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

}
