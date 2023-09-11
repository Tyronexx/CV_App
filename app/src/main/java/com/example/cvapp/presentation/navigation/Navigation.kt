package com.example.cvapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cvapp.presentation.CvUiState
import com.example.cvapp.presentation.screens.CVScreen.CvScreen
import com.example.cvapp.presentation.screens.CVScreen.CvViewModel
import com.example.cvapp.presentation.screens.EditScreen.EditScreen

@Composable
fun Navigation(
    viewModel: CvViewModel,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.CVScreen.name,
    ){

        composable(route = Screens.CVScreen.name){
            CvScreen(viewModel = viewModel, navController = navController, modifier = Modifier.padding(10.dp))
        }

        composable(route = Screens.EditScreen.name){
            EditScreen(viewModel = viewModel, navController = navController, modifier = Modifier.padding(20.dp))
        }

    }
}