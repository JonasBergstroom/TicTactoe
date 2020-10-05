package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class botPlayer_wins : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_player_wins)

        val bu1ttagain : Button = findViewById(R.id.bu1again)
        bu1ttagain.setOnClickListener {
            val intent = Intent(this, welcome :: class.java)

            startActivity(intent)
        }
    }
}