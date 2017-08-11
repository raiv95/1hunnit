package com.example.varun.a4inarow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int gameBoard[][];
    int positionBoard[][];
    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = new Board();
    }

    public int getCircleID(String ID) {
        positionBoard = board.getPositionBoard();
        int identifier = Integer.valueOf(ID);
        int column = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (positionBoard[i][j] == identifier) {
                    column = j;
                }
            }
        }
        return column;
    }

    public int getRow(int column) {
        gameBoard = board.getGameBoard();
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (gameBoard[i][column] == 0) {
                return i;
            }
        }
        return row;
    }

    public void buttonClicked(View view) {
        positionBoard = board.getPositionBoard();
        gameBoard = board.getGameBoard();
        int player = board.getPlayer();

        // getting the string based on the id
        int id = view.getId();
        Log.e("ID",Integer.toString(id));
        String name = view.getResources().getResourceName(id);


        // getting the last two digits from the resource name
        String temp[] = name.split("/");
        String newName = temp[1];
        newName = newName.replaceAll("\\D+","");

        int newID;
        int column = getCircleID(newName);
        int row = getRow(column);
        Log.e("RowColumn", Integer.toString(row) + " " + Integer.toString(column));
        int currentID = Integer.valueOf(newName);
        newID = positionBoard[row][column] - currentID;
        view = findViewById(id + newID);
        // based on player should make this switch statement
        // two players is simple
        // single player need to implement AI
        if (gameBoard[row][column] == 0) {
            if (player == 1) {
                view.setBackgroundResource(R.drawable.red);
                gameBoard[row][column] = 1;
                board.setGameBoard(gameBoard);
                board.setPlayers(player);
            } else if (player == 2) {
                view.setBackgroundResource(R.drawable.yellow);
                gameBoard[row][column] = 2;
                board.setGameBoard(gameBoard);
                board.setPlayers(player);
            }
        }
        // code for checking winners goes below
        int status = checkBoardStatus();
        if (status == 1) {
            Toast.makeText(getApplicationContext(), "Player 1 Wins!", Toast.LENGTH_LONG).show();
            board.initializeBoard();
            setContentView(R.layout.activity_main);
        } else if (status == 2) {
            Toast.makeText(getApplicationContext(), "Player 2 Wins!", Toast.LENGTH_LONG).show();
            board.initializeBoard();
            setContentView(R.layout.activity_main);
        }

        // reset the board if full
        if (board.fullBoard()) {
            Toast.makeText(getApplicationContext(), "Full board reinitialized", Toast.LENGTH_LONG).show();
            board.initializeBoard();
            setContentView(R.layout.activity_main);
        }
    }

    public int checkBoardStatus() {
        int vert, horiz;

        if ((vert = board.verticalWinner()) > 0) {
            return vert;
        }

        if ((horiz = board.horizontalWinner()) > 0) {
            return horiz;
        }
        return 0;
    }

}
