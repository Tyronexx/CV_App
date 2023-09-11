package com.example.cvapp.presentation.screens.CVScreen

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cvapp.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CvScreen(
    modifier: Modifier = Modifier,
//    cvUiState: CvUiState,
    viewModel: CvViewModel,
    navController: NavController
) {

    val cvUiState by viewModel.cvUiState.collectAsState()

    val scrollState = rememberScrollState()

    Scaffold (
        topBar = {
                 TopAppBar(
                     title = { Text(text = "CV APP" , color = Color.White) },
                     colors = TopAppBarDefaults.smallTopAppBarColors(
                         containerColor = MaterialTheme.colorScheme.primary
                     ),
                 )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = {
                navController.navigate(Screens.EditScreen.name)
            }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Text(text = "Edit")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ){
        ElevatedCard(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 100.dp,
            ),
        ) {

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Column {
                    Text(
                        text = "Full Name",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = cvUiState.fullName,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                        )
                    )
                }
                Column {
                    Text(
                        text = "Slack User Name",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = cvUiState.userName,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                        )
                    )
                }
                Column {
                    Text(
                        text = "Github Handle",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = cvUiState.githubHandle,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                        )
                    )
                }
                Column {
                    Text(
                        text = "Personal Bio",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = cvUiState.personalBio,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                        )
                    )
                }

            }

        }

    }
}