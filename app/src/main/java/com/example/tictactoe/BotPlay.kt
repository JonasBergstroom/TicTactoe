package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_bot_play.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext
import com.example.tictactoe.Draw as Draw

class BotPlay : AppCompatActivity(),CoroutineScope {


    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var db : AppDatabase

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_play)


        job = Job()

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Winners")
            .fallbackToDestructiveMigration()
            .build()


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

    var player = ArrayList<Int>()
    var botPlayer = ArrayList<Int>()
    var drawCount = ArrayList<Int>()
    var hardplay = ArrayList<Int>()

    // Made a separate player to make the "BotPlay" work with the rules.



    var activePlayer = 3
    var drawPlayer = 1




    fun playGame(buttID: Int, buttSelected: Button)

    // Creates player and botPlayer in a ArrayList, and a function called "playGame".
    // Also creates a "activePlayer" variable.
    // The value of the activePlayer always start with "1", when the game starts.

    // To make a "draw" situation work, I created a invisible "drawCount" and a "drawPlayer".
    // The "drawPlayer" works as a "ghost" in the background to count all the clicks.

    {

        if(activePlayer == 3) {
            hardplay.add(buttID)
            activePlayer = 2
            botPlay()

            // The game begins with "activePlayer" = 3. When a button is selected by the "player", "hardplay" then adds a "ButtID" so that the button cannot be clicked again.
            // "player" starts with a single "buttID" when you click on it, meanwhile "botPlayer" adds two random "buttID" to make the game a little more difficult.
            // "botPlayer" only adds two "buttID" during the first move that "botPlayer" makes in a game. Then the game continues normally.

        }


        if(drawPlayer == 1) {
            drawCount.add(buttID)

            // "drawPlayer" always has the value "1" to make it run the whole game.
            // It is also separated from to other players, but runs invisible in the background during every click a player make.
        }

        if(activePlayer == 1) {
            buttSelected.text = "X"
            buttSelected.setBackgroundColor(Color.parseColor("RED"))
            player.add(buttID)
            activePlayer = 2
            botPlay()

            // Makes the other player a "botPlayer".


            // player starts with the activePlayers value as "1", until she/he chooses to click on a button.
            // Then the "activePlayer" value becomes "2".
            // When player chooses a button to click, the appearance of the button change to an "X" with the background color Green.


        }else if(activePlayer == 2){
            buttSelected.text = "O"
            buttSelected.setBackgroundColor(Color.parseColor("GREEN"))
            botPlayer.add(buttID)
            activePlayer = 1


            // It is now botPlayer turn to play because the value of the "activePlayer" became "2".
            // After botPlayer chooses to click on a button the "activePlayer" value becomes "1" again.
            // When botPlayer chooses a button to click, the appearance of the button change to an "O" with the background color Red.

        }

        buttSelected.isEnabled = false

        // When a player chooses to click on a button, that button can't be clicked again.

        checkResult()

        // Making the "checkWinner" function connect to the "playGame" function.

    }

    fun botPlay() {
        val emptyButtID = ArrayList<Int>()
        for(buttID in 1 ..9) {
            if(!(player.contains(buttID) || botPlayer.contains(buttID) || hardplay.contains(buttID))) {
                emptyButtID.add(buttID)
            }
            // Made a "botPlay" function. The "bot player" always check if any of the 9 "buttID" is selected, so it can't be clicked on.
            // When the "botPlayer" finds a empty "buttID" it adds an "emptyButtID" to the game, that contains a "buttID".
            // Also checks if "hardplay" contains any "buttID".

        }


        val r = Random()


        val randIndex = r.nextInt(emptyButtID.size+0)+0
        val buttID = emptyButtID[randIndex]

        // Makes "botPlayer" randomly select between available "emptyButtID" from 1 - 9.

        val buttSelected : Button

        when(buttID){

            1-> buttSelected = bu1
            2-> buttSelected = bu2
            3-> buttSelected = bu3
            4-> buttSelected = bu4
            5-> buttSelected = bu5
            6-> buttSelected = bu6
            7-> buttSelected = bu7
            8-> buttSelected = bu8
            9-> buttSelected = bu9

            // Makes all the buttons work when the "botPlayer" plays.

            else -> buttSelected = bu1

            // Making "else" = bu1 to not get any errors.
        }

        playGame(buttID, buttSelected)

        // Continues the game after "botPlayer" made a choice.

    }


    fun checkResult() {
        var winner = -1

        // No player is winner at the start, because the value of the "winner" = -1 at start.

        if(player.contains(1) && player.contains(2) && player.contains(3)) {
            winner = 1
        }else if(drawCount.contains(1) && drawCount.contains(2) && drawCount.contains(3) &&
            drawCount.contains(4) && drawCount.contains(5) && drawCount.contains(6) &&
            drawCount.contains(7) && drawCount.contains(8) && drawCount.contains(9)) {
            winner = 3

            // Sets the combination for a draw situation with the name "drawCount".
            // Had to move it to the top from the bottom in order to get it work correctly, without any bug.
        }


        if(botPlayer.contains(1) && botPlayer.contains(2) && botPlayer.contains(3)) {
            winner = 2
        }

        if(player.contains(1) && player.contains(5) && player.contains(9)) {
            winner = 1
        }
        if(botPlayer.contains(1) && botPlayer.contains(5) && botPlayer.contains(9)) {
            winner = 2
        }

        if(player.contains(3) && player.contains(5) && player.contains(7)) {
            winner = 1
        }
        if(botPlayer.contains(3) && botPlayer.contains(5) && botPlayer.contains(7)) {
            winner = 2
        }

        if(player.contains(1) && player.contains(4) && player.contains(7)) {
            winner = 1
        }
        if(botPlayer.contains(1) && botPlayer.contains(4) && botPlayer.contains(7)) {
            winner = 2
        }



        if(player.contains(4) && player.contains(5) && player.contains(6)) {
            winner = 1
        }
        if(botPlayer.contains(4) && botPlayer.contains(5) && botPlayer.contains(6)) {
            winner = 2
        }

        if(player.contains(7) && player.contains(8) && player.contains(9)) {
            winner = 1
        }
        if(botPlayer.contains(7) && botPlayer.contains(8) && botPlayer.contains(9)) {
            winner = 2
        }


        if(player.contains(2) && player.contains(5) && player.contains(8)) {
            winner = 1
        }
        if(botPlayer.contains(2) && botPlayer.contains(5) && botPlayer.contains(8)) {
            winner = 2
        }

        if(player.contains(3) && player.contains(6) && player.contains(9)) {
            winner = 1
        }
        if(botPlayer.contains(3) && botPlayer.contains(6) && botPlayer.contains(9)) {
            winner = 2
        }


        // Making the rules in the game, in the function "checkWinner".
        // Sets all possible combinations for each player, in order to win.



        val player_Won = Intent(this, Player_Wins :: class.java)
        val botPlayer_Won = Intent(this, botPlayer_wins :: class.java)

        val Drawb = Intent(this, DrawBotPlay :: class.java)


        // Making 2 different values for two different activities, "player_Won" and "botPlayer_Won" that will show depending on which player wins.


        if(winner != -1) {
            if (winner == 1) {
                startActivity(player_Won)
                //   Toast.makeText(this, "Player 1 won the game!", Toast.LENGTH_LONG).show()
                if(count == 0){
                    count ++
                val item = winners(0,"Player")
                saveItem(item)
                }

            }
            // When the value of the "winner" ends with == 1, player wins. Then a separate activity starts that shows "Player won!"

            else if (winner == 2) {
                startActivity(botPlayer_Won)
                // Toast.makeText(this, "Player 2 won the game!", Toast.LENGTH_LONG).show()
                if(count == 0){
                    count ++
                val item = winners(0,"BotPlayer")
                saveItem(item)
                }

            }
            // When the value of the "winner" ends with 2, botplayer wins. Then a separate activity starts that shows "BotPlayer won!"

            else{
                startActivity(Drawb)
                //  Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show()
            }

            // When the value of the "winner" ends with 3, no one wins, it is a draw!. Then a separate activity starts that shows "Draw!"

        }
    }
    fun saveItem(item : winners) {
        launch(Dispatchers.IO) {
            db.WinnerDao().insert(item)
        }
    }
}









