package com.example.cvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cvapp.presentation.navigation.Navigation
import com.example.cvapp.presentation.screens.CVScreen.CvViewModel
import com.example.cvapp.ui.theme.CVAppTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CvViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(viewModel = viewModel)
                }
            }
        }
    }
}

