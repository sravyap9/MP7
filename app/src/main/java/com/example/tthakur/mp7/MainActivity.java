package com.example.tthakur.mp7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean gameOver;
    boolean playerOneTurn;
    boolean isDraw;

    Button topLeft;
    Button topCenter;
    Button topRight;

    Button middleLeft;
    Button middleCenter;
    Button middleRight;

    Button bottomLeft;
    Button bottomCenter;
    Button bottomRight;

    Button newGame;

    ArrayList<Button> buttonList;

    char board[][] = new char[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeft = findViewById(R.id.topLeft);
        topCenter = findViewById(R.id.topCenter);
        topRight = findViewById(R.id.topRight);

        middleLeft = findViewById(R.id.middleLeft);
        middleCenter = findViewById(R.id.middleCenter);
        middleRight = findViewById(R.id.middleRight);

        bottomLeft = findViewById(R.id.bottomLeft);
        bottomCenter = findViewById(R.id.bottomCenter);
        bottomRight = findViewById(R.id.bottomRight);

        newGame = findViewById(R.id.newGameButton);

        buttonList = new ArrayList<>();
        buttonList.add(topLeft);
        buttonList.add(topCenter);
        buttonList.add(topRight);

        buttonList.add(middleLeft);
        buttonList.add(middleCenter);
        buttonList.add(middleRight);

        buttonList.add(bottomLeft);
        buttonList.add(bottomCenter);
        buttonList.add(bottomRight);

        resetGame();

        newGame.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                resetGame();
            }
        });

        topLeft.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (topLeft.getText() == " ")
                {
                    runTurn(topLeft);
                }
            }
        });

        topCenter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (topCenter.getText() == " ")
                {
                    runTurn(topCenter);
                }
            }
        });

        topRight.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (topRight.getText() == " ")
                {
                    runTurn(topRight);
                }
            }
        });

        middleLeft.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (middleLeft.getText() == " ")
                {
                    runTurn(middleLeft);
                }
            }
        });

        middleCenter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (middleCenter.getText() == " ")
                {
                    runTurn(middleCenter);
                }
            }
        });

        middleRight.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (middleRight.getText() == " ")
                {
                    runTurn(middleRight);
                }
            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (bottomLeft.getText() == " ")
                {
                    runTurn(bottomLeft);
                }
            }
        });

        bottomCenter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (bottomCenter.getText() == " ")
                {
                    runTurn(bottomCenter);
                }
            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (bottomRight.getText() == " ")
                {
                    runTurn(bottomRight);
                }
            }
        });

    }

    public void invalidMove()
    {
        Toast.makeText(getApplicationContext(), "Invalid Move!", Toast.LENGTH_SHORT).show();
    }

    public void clearBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }

        for (int i = 0; i < buttonList.size(); i++)
        {
            buttonList.get(i).setText(" ");
        }
    }

    public void resetGame()
    {
        gameOver = false;
        playerOneTurn = true;
        isDraw = false;
        clearBoard();
    }

    public void runTurn(Button clicked)
    {
        if(!gameOver)
        {
            if (playerOneTurn)
            {
                Toast.makeText(getApplicationContext(), "Player Two Turn", Toast.LENGTH_SHORT).show();
                clicked.setText("X");
                playerOneTurn = false;
            }

            else
            {
                Toast.makeText(getApplicationContext(), "Player One Turn", Toast.LENGTH_SHORT).show();
                clicked.setText("O");
                playerOneTurn = true;
            }
        }
    }
}
