package com.example.tictactoe

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

    var activePlayer = 1


    private fun playGame(buttID: Int, buttSelected: Button)

    // Creates player 1 and player 2 in a ArrayList, and a function called "playGame".
    // Also creates a "activePlayer" variable.
    // The value of the activePlayer always start with "1", when the game starts.

    {

        if (activePlayer == 1) {
            buttSelected.text = "X"
            buttSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(buttID)
            activePlayer = 2

            // player 1 starts with the activePlayers value as "1", until she/he chooses to click on a button.
            // Then the activePlayer value becomes "2".
            // When player 1 chooses a button to click, the appearance of the button change to an "X" with the background color blue.

        }else{
            buttSelected.text = "O"
            player2.add(buttID)
            buttSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            activePlayer = 1

            // It is now player 2 turn to play because the value of the activePlayer became "2".
            // After player 2 chooses to click on a button the activePlayer value becomes "1" again.
            // When player 2 chooses a button to click, the appearance of the button change to an "O" with the background color orange.

        }
        buttSelected.isEnabled = false

        // When a player chooses to click on a button, that button can't be clicked again.

      }

    }



