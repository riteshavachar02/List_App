package com.example.listapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface ListItemDao {
    @Query("SELECT * FROM list_item")
    fun getAllList(): Flow<List<ListItem>> // Returns Flow of a List of ListItem (valid)

    @Insert
    suspend fun insert(item: ListItem) // Accepts a single ListItem entity

}
