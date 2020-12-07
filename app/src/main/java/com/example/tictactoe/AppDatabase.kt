package com.example.tictactoe

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(winners::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun WinnerDao() : winnerDao
}