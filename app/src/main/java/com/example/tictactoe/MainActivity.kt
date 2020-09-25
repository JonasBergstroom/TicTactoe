package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buttClick(view: View) {
        val buttSelected = view as Button
        var buttID = 0
        when(buttSelected.id){
            R.id.bu1 -> buttID = 1
            R.id.bu2 -> buttID = 2
            R.id.bu3 -> buttID = 3
            R.id.bu4 -> buttID = 4
            R.id.bu5 -> buttID = 5
            R.id.bu6 -> buttID = 6
            R.id.bu7 -> buttID = 7
            R.id.bu8 -> buttID = 8
            R.id.bu9 -> buttID = 9


            // Made a function called "buttClick".
            // Created a "buttID" variable for later use in the future functions.
            // Used a "when expression" for each buttons clicked.
            // Made a "Toast text" to see if the buttons correctly worked.

        }

        playGame(buttID,buttSelected)

        // Making the "playGame" function connect to the "buttClick" function.

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var drawCount = ArrayList<Int>()

    var activePlayer = 1
    var drawPlayer = 1



    fun playGame(buttID: Int, buttSelected: Button)

    // Creates player 1 and player 2 in a ArrayList, and a function called "playGame".
    // Also creates a "activePlayer" variable.
    // The value of the activePlayer always start with "1", when the game starts.

    // To make a "draw" situation work, I created a invisible "drawCount" and a "drawPlayer".
    // The "drawPlayer" works as a "ghost" in the background to count all the clicks.

    {


        if(drawPlayer == 1) {
            drawCount.add(buttID)

            // "drawPlayer" always has the value "1" to make it run the whole game.
            // It is also separated from to other players, but runs invisible in the background during every click a player make.
        }

        if(activePlayer == 1) {
            buttSelected.text = "X"
            buttSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(buttID)
            activePlayer = 2

            // player 1 starts with the activePlayers value as "1", until she/he chooses to click on a button.
            // Then the "activePlayer" value becomes "2".
            // When player 1 chooses a button to click, the appearance of the button change to an "X" with the background color blue.

        }else if(activePlayer == 2){
            buttSelected.text = "O"
            player2.add(buttID)
            buttSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            activePlayer = 1

            // It is now player 2 turn to play because the value of the "activePlayer" became "2".
            // After player 2 chooses to click on a button the "activePlayer" value becomes "1" again.
            // When player 2 chooses a button to click, the appearance of the button change to an "O" with the background color orange.
        }

        buttSelected.isEnabled = false

        // When a player chooses to click on a button, that button can't be clicked again.

        checkResult()

        // Making the "checkWinner" function connect to the "playGame" function.

    }

    fun checkResult() {
        var winner = -1

        // No player is winner at the start, because the value of the "winner" = -1 at start.

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }



        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if(drawCount.contains(1) && drawCount.contains(2) && drawCount.contains(3) &&
            drawCount.contains(4) && drawCount.contains(5) && drawCount.contains(6) &&
            drawCount.contains(7) && drawCount.contains(8) && drawCount.contains(9)) {
            winner = 3
        }

        // Making the rules in the game, in the function "checkWinner".
        // Sets all possible combinations for each player, in order to win.

        // Also sets the combination for a draw situation with the name "drawCount".


        val player1_Won = Intent(this, Player1_Wins :: class.java)
        val player2_Won = Intent(this, player2_wins :: class.java)

        // Making 2 different values for two different activities, "player1_Won" and "player2_Won" that will show depending on which player wins.


        if(winner != -1) {
            if (winner == 1) {
                startActivity(player1_Won)
             //   Toast.makeText(this, "Player 1 won the game!", Toast.LENGTH_LONG).show()
            }
            // When the value of the "winner" ends with == 1, player 1 wins. Then a separate activity starts that shows "Player 1 won!"

            else if (winner == 2) {
                startActivity(player2_Won)
               // Toast.makeText(this, "Player 2 won the game!", Toast.LENGTH_LONG).show()
            }
            // When the value of the "winner" ends with 2, player 2 wins. Then a separate activity starts that shows "Player 2 won!"

            else{
                Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
            }

            // When the value of the "winner" ends with 3, no one wins, it is a draw!. Then a "Toast" text appears with the message "Draw!"

        }

    }
}

