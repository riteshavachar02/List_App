package com.example.listapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_item")
data class ListItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)

