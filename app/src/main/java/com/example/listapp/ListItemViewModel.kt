package com.example.listapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapp.data.ListItem
import com.example.listapp.data.ListItemRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ListItemViewModel(private val repository: ListItemRepository) : ViewModel() {

    val items: StateFlow<List<ListItem>> = repository.allItems
        .map { it.sortedBy { item -> item.id } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addItem(id: Int, name: String) {
        viewModelScope.launch {
            repository.addItem(ListItem(id, name))
        }
    }
}