package com.example.cvapp.presentation.screens.EditScreen

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cvapp.presentation.screens.CVScreen.CvViewModel

@Composable
fun EditScreen(
    modifier: Modifier = Modifier,
    viewModel: CvViewModel,
    navController: NavController
) {
    val cvUiState by viewModel.cvUiState.collectAsState()

    val fullName = cvUiState.fullName
    val userName = cvUiState.userName
    val githubHandle = cvUiState.githubHandle
    val personalBio = cvUiState.personalBio

    val scrollState = rememberScrollState()

/*
    var testString by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        EditTextField(
            label = "Full Name",
            value = testString,
            onValueChange = { testString=it }
        )
        Text(text = testString)
    }
*/

    ElevatedCard (
        elevation = CardDefaults.cardElevation(
            defaultElevation = 100.dp
        ),
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(scrollState)
        ){

            Column {
                Text(
                    text = "Full Name",
                )
                Spacer(modifier = Modifier.height(5.dp))
                EditTextField(
                    label = "Full Name",
                    value = fullName,
                    onValueChange = { viewModel.updateFullName(name = it) }
                )
            }


            Column {
                Text(text = "Slack User Name")
                Spacer(modifier = Modifier.height(5.dp))
                EditTextField(
                    label = "Slack User Name",
                    value = userName,
                    onValueChange = { viewModel.updateUserName(name = it) }
                )
            }

            Column {
                Text(text = "Github Handle")
                Spacer(modifier = Modifier.height(5.dp))
                EditTextField(
                    label = "Github Handle",
                    value = githubHandle,
                    onValueChange = { viewModel.updateGithubHandle(handle = it) }
                )
            }

            Column {
                Text(text = "Personal Bio")
                Spacer(modifier = Modifier.height(5.dp))
                EditTextField(
                    label = "Personal Bio",
                    value = personalBio,
                    onValueChange = { viewModel.updatePersonalBio(bio = it) }
                )
            }

//        EditTextField(
//            label = "Full Name",
//            value = fullName,
//            onValueChange = { viewModel.updateName(name = it) }
//        )
//        EditTextField(
//            label = "Full Name",
//            value = fullName,
//            onValueChange = { viewModel.updateName(name = it) }
//        )
//        EditTextField(
//            label = "Full Name",
//            value = fullName,
//            onValueChange = { viewModel.updateName(name = it) }
//        )


//        Text(text = fullName)


            Button(onClick = {
                navController.popBackStack()
            }) {
                Text(text = "Save")
            }
        }
    }



}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardActions = KeyboardActions.Default
    )
}
