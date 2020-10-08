package com.example.tictactoe
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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



    }





}