package com.example.listapp

import android.app.Application
import androidx.room.Room
import com.example.listapp.data.AppDataBase
import com.example.listapp.data.ListItemRepository

class ListApp : Application() {
    val database by lazy {
        Room.databaseBuilder(this, AppDataBase::class.java, "list_item_db").build()
    }

    val repository by lazy { ListItemRepository(database.ListItemDao()) }
}