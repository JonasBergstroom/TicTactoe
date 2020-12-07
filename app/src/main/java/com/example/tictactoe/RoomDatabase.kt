package com.example.tictactoe

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.temp.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class RoomDatabase : AppCompatActivity() , CoroutineScope {

    private lateinit var job : Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temp)
        job = Job()

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Winners")
            .fallbackToDestructiveMigration()
            .build()


        val list = loadAllItems()
        launch {
            var previousText = ""
            val itemList = list.await()
            for (item in itemList) {
                Log.d("!!!", "${item.name}")
                previousText += item.name.toString() + "\n"

            }
            previousList.text = previousText
            previousList.setMovementMethod(ScrollingMovementMethod())

        }
    }

    fun saveItem(item: winners) {
        launch(Dispatchers.IO) {
            db.WinnerDao().insert(item)
        }
    }


    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

      fun loadAllItems() : Deferred<List<winners>>  =
        async(Dispatchers.IO) {
         db.WinnerDao().getAll()
        }



}