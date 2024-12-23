package com.example.listapp.data

import kotlinx.coroutines.flow.Flow



class ListItemRepository(private val listItemDao: ListItemDao) {
    val allItems: Flow<List<ListItem>> = listItemDao.getAllList()

    suspend fun addItem(item: ListItem) {
        listItemDao.insert(item)
    }
}