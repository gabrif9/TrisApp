package com.example.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);


    }

    public void clickOnButton(View view){

        Button button = (Button) view;
        int id = button.getId();
        int cell = 0;
        counter++;
        System.out.println(id);

        switch (id){
            case R.id.b1:
                //Toast.makeText(getApplicationContext(), "b1", Toast.LENGTH_SHORT).show();
                cell = 1;
                break;

            case R.id.b2:
                //Toast.makeText(getApplicationContext(), "b2", Toast.LENGTH_SHORT).show();
                cell = 2;
                break;

            case R.id.b3:
                //Toast.makeText(getApplicationContext(), "b3", Toast.LENGTH_SHORT).show();
                cell = 3;
                break;

            case R.id.b4:
                //Toast.makeText(getApplicationContext(), "b4", Toast.LENGTH_SHORT).show();
                cell = 4;
                break;

            case R.id.b5:
                //Toast.makeText(getApplicationContext(), "b5", Toast.LENGTH_SHORT).show();
                cell = 5;
                break;

            case R.id.b6:
                //Toast.makeText(getApplicationContext(), "b6", Toast.LENGTH_SHORT).show();
                cell = 6;
                break;

            case R.id.b7:
                //Toast.makeText(getApplicationContext(), "b7", Toast.LENGTH_SHORT).show();
                cell = 7;
                break;

            case R.id.b8:
                //Toast.makeText(getApplicationContext(), "b8", Toast.LENGTH_SHORT).show();
                cell = 8;
                break;

            case R.id.b9:
                //Toast.makeText(getApplicationContext(), "b9", Toast.LENGTH_SHORT).show();
                cell = 9;
                break;
        }

        startgame(cell, button);
    }

    List<Integer> player1 = new ArrayList<>();
    List<Integer> player2 = new ArrayList<>();

    int onlinePlayer = 1;

    private void startgame(int cell, Button button) {
        if (onlinePlayer == 1){
            button.setText("X");
            button.setBackgroundColor(Color.RED);
            player1.add(cell);
            onlinePlayer = 2;
            multiplayer();
        } else {
            button.setText("O");
            button.setBackgroundColor(Color.BLUE);
            player2.add(cell);
            onlinePlayer = 1;
        }

        button.setEnabled(false);
        checkWinner();
    }

    private void multiplayer(){
        if (counter < 10/2){
            //1 if the cell is empty, 0 otherwise
            List<Integer> emptyCell = new ArrayList<>();

            for (int i=1; i<10; i++){
                if (!(player1.contains(i) || player2.contains(i))){
                    emptyCell.add(i);
                }
            }

            Random random = new Random();
            int rIndex = random.nextInt(emptyCell.size());
            int cellID = emptyCell.get(rIndex);

            Button b = null;

            switch (cellID){
                case 1:
                    b = b1;
                    break;

                case 2:
                    b = b2;
                    break;

                case 3:
                    b = b3;
                    break;

                case 4:
                    b = b4;
                    break;

                case 5:
                    b = b5;
                    break;

                case 6:
                    b = b6;
                    break;

                case 7:
                    b = b7;
                    break;

                case 8:
                    b = b8;
                    break;

                case 9:
                    b = b9;
                    break;
            }

            startgame(cellID, b);
        }

    }

    private void checkWinner(){
        int winner = -1;

        //prima riga
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1;
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2;
        }

        //seconda riga
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1;
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2;
        }

        //terza riga
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1;
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2;
        }

        //prima colonna
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1;
        } else if (player2.contains(7) && player2.contains(1) && player2.contains(4)){
            winner = 2;
        }

        //seconda colonna
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1;
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2;
        }

        //terza colonna
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1;
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2;
        }

        //prima diagonale
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1;
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2;
        }

        //seconda diagonale
        if (player1.contains(7) && player1.contains(3) && player1.contains(5)){
            winner = 1;
        } else if (player2.contains(7) && player2.contains(3) && player2.contains(5)){
            winner = 2;
        }

        if (winner != -1){
            Toast.makeText(getApplicationContext(), "Ha vinto il giocatore: " + winner, Toast.LENGTH_SHORT).show();
        }
    }
}