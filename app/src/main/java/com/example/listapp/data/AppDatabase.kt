package com.example.listapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ListItem::class],
    version = 1
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun ListItemDao(): ListItemDao
}