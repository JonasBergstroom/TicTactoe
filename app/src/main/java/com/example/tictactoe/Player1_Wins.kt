package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Player1_Wins : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player1__wins)

        val bu2ttagain : Button = findViewById(R.id.bu2again)
        bu2ttagain.setOnClickListener {
            val intent = Intent(this, welcome :: class.java)

            startActivity(intent)
        }
    }
}