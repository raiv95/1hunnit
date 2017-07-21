package com.example.varun.a4inarow;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int player = 1;
    String colorBoard[][];
    int positionBoard[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorBoard = new String[][] {
                {"grey","grey","grey","grey","grey","grey","grey"},
                {"grey","grey","grey","grey","grey","grey","grey"},
                {"grey","grey","grey","grey","grey","grey","grey"},
                {"grey","grey","grey","grey","grey","grey","grey"},
                {"grey","grey","grey","grey","grey","grey","grey"},
                {"grey","grey","grey","grey","grey","grey","grey"}
        };

        positionBoard = new int[][] {
                {1,2,3,4,5,6,7},
                {8,9,10,11,12,13,14},
                {15,16,17,18,19,20,21},
                {22,23,24,25,26,27,28},
                {29,30,31,32,33,34,35},
                {36,37,38,39,40,41,42},
        };
    }

    public int getCircleID(String ID) {
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

    public int getRow(int player, int column) {
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (colorBoard[i][column] == "grey") {
                return i;
            }
        }
        return row;
    }
    // Game board (by number ID)
    // 1 2 3 4 5 6 7
    // 8 9 10 11 12 13 14
    // 15 16 17 18 19 20 21
    // 22 23 24 25 26 27 28
    // 29 30 31 32 33 34 35
    // 36 37 38 39 40 41 42
    public void buttonClicked(View view) {

        // getting the string based on the id
        int id = view.getId();
        Log.e("ID",Integer.toString(id));
        String name = view.getResources().getResourceName(id);


        // getting the last two digits from the resource name
        String temp[] = name.split("/");
        String newName = temp[1];
        newName = newName.replaceAll("\\D+","");

        //
        int newID;
        int column = getCircleID(newName);
        int row = getRow(player,column);
        Log.e("RowColumn", Integer.toString(row) + " " + Integer.toString(column));
        int currentID = Integer.valueOf(newName);
        newID = positionBoard[row][column] - currentID;
        view = findViewById(id + newID);
        // based on player should make this switch statement
        // two players is simple
        // single player need to implement AI
        if (player == 1) {
            view.setBackgroundResource(R.drawable.red);
            colorBoard[row][column] = "red";
            player = 2;
        } else if (player == 2) {
            view.setBackgroundResource(R.drawable.yellow);
            colorBoard[row][column] = "yellow";
            player = 1;
        }
    }
}
