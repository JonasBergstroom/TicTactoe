package com.example.tictactoe

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface winnerDao {

    @Insert
    fun insert(item: winners)

    @Delete
    fun delete(item: winners)

    @Query("SELECT * FROM winners")
    fun getAll() : List<winners>

}