package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_bot_player_wins.*
import kotlinx.android.synthetic.main.activity_player2_wins.*

class player2_wins : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player2_wins)

        val bu3ttagain : Button = findViewById(R.id.bu3again)
        bu3ttagain.setOnClickListener {
            val intent = Intent(this, welcome :: class.java)

            startActivity(intent)
        }


        quitbutt3.setOnClickListener {

            // Made a "quitbutt3" that will be able to click on.

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