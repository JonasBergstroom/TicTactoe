package com.example.tictactoe

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

        Toast.makeText(this, "butt ID: "+buttID, Toast.LENGTH_LONG).show()


    }



}