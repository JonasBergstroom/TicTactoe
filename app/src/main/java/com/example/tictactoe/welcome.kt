package com.example.tictactoe
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_player__wins.*
import kotlinx.android.synthetic.main.activity_welcome.*

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity :: class.java)

            startActivity(intent)
        }

        // When you click on the button "Play!" you will start the "MainActivity" and open the "playGame" tab.

        val buttonb : Button = findViewById(R.id.buttonbot)
        buttonb.setOnClickListener {
            val intentb = Intent(this, BotPlay :: class.java)

            startActivity(intentb)
        }
        val buttonscore : Button = findViewById(R.id.buttonscore)
        buttonscore.setOnClickListener {
            val intent = Intent(this, com.example.tictactoe.RoomDatabase :: class.java)

            startActivity(intent)
        }



        quitbutt5.setOnClickListener {

            // Made a "quitbutt4" that will be able to click on.

            val builder = AlertDialog.Builder(this)

            // Made a "builder" variable to add the context in the "AlertDialog".

            builder.setTitle("Exit game")

            builder.setIcon(R.drawable.ic_action_warning)

            builder.setMessage("Are you sure?")

            // Added the Title an icon and a message in the dialog.

            builder.setPositiveButton("Yes") {
                    dialog, which ->
                finishAffinity()
            }

            // When you click "Yes" the app will shut down.

            builder.setNegativeButton("No") {
                    dialog, which ->
            }
            // When you click "No" nothing will happen and the alert window will disappear.

            val dialog : AlertDialog = builder.create()
            dialog.show()

            // Makes all "builder" work together to make everything work properly.

        }



    }





}