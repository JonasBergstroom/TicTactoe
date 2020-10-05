package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Draw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)

        val bu4ttagain : Button = findViewById(R.id.bu4again)
        bu4ttagain.setOnClickListener {
            val intent = Intent(this, welcome :: class.java)

            startActivity(intent)
        }
    }
}