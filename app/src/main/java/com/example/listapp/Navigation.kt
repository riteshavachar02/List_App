package com.example.listapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(viewModel: ListItemViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {
        composable("list") {
            ListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("add") }
            )
        }
        composable("add") {
            AddScreen(
                onCancel = { navController.popBackStack() },
                onAdd = { id, name ->
                    viewModel.addItem(id, name)
                    navController.popBackStack()
                }
            )
        }
    }
}
