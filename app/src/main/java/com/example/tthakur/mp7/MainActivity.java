package com.example.tthakur.mp7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean gameOver;
    boolean playerOneTurn;
    boolean isDraw;

    TextView playerOneScoreText;
    TextView playerTwoScoreText;

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

    int playerOneScore = 0;
    int playerTwoScore = 0;

    ArrayList<Button> buttonList;

    char board[][] = new char[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScoreText = findViewById(R.id.playerOneTB);
        playerTwoScoreText = findViewById(R.id.playerTwoTB);

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
            
        }
    }

    public String checkWin()
    {
        //Horizontals
        if ((topLeft.getText() == topCenter.getText()) &&
                (topCenter.getText() == topRight.getText()) &&
                (!isEmpty(topLeft, topCenter, topRight)))
        {
            return "win";
        }
        else if ((middleLeft.getText() == middleCenter.getText())
                && (middleCenter.getText() == middleRight.getText()) &&
                (!isEmpty(middleLeft, middleCenter, middleRight)))
        {
            return "win";
        }
        else if ((bottomLeft.getText() == bottomCenter.getText()) &&
                (bottomCenter.getText() == bottomRight.getText()) &&
                (!isEmpty(bottomLeft, bottomCenter, bottomRight)))
        {
            return "win";
        }

        //Verticals
        else if ((topLeft.getText() == middleLeft.getText()) &&
                (middleLeft.getText() == bottomLeft.getText()) &&
                (!isEmpty(topLeft, middleLeft, bottomLeft)))
        {
            return "win";
        }
        else if ((topCenter.getText() == middleCenter.getText()) &&
                (middleCenter.getText() == bottomCenter.getText()) &&
                (!isEmpty(topCenter, middleCenter, bottomCenter)))
        {
            return "win";
        }
        else if ((topRight.getText() == middleRight.getText()) &&
                (middleRight.getText() == bottomRight.getText()) &&
                (!isEmpty(topRight, middleRight, bottomRight)))
        {
            return "win";
        }

        //Diagonals
        else if ((topLeft.getText() == middleCenter.getText()) &&
                (middleCenter.getText() == bottomRight.getText()) &&
                (!isEmpty(topLeft, middleCenter, bottomRight)))
        {
            return "win";
        }
        else if ((topRight.getText() == middleCenter.getText()) &&
                (middleCenter.getText() == bottomLeft.getText()) &&
                (!isEmpty(topRight, middleCenter, bottomLeft)))
        {
            return "win";
        }

        //draw
        else if (checkDraw())
        {
            return "draw";
        }

        return "noWin";

    }

    public boolean isEmpty(Button first, Button second, Button third)
    {
        if (first.getText() != " " && second.getText() != " " && third.getText() != " ")
        {
            return false;
        }

        return true;
    }

    public boolean checkDraw()
    {
        for (int i = 0; i < buttonList.size(); i++)
        {
            if (buttonList.get(i).getText() == " ")
            {
                return false;
            }
        }

        return true;
    }
}
