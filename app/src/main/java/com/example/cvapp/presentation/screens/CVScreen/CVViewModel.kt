package com.example.cvapp.presentation.screens.CVScreen

import androidx.lifecycle.ViewModel
import com.example.cvapp.presentation.CvUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CvViewModel : ViewModel() {

    private val _cvUiState = MutableStateFlow(CvUiState())
    val cvUiState: StateFlow<CvUiState> = _cvUiState.asStateFlow()

/*
    fun updateData(newName: String, userName: String, githubHandle: String, personalBio: String){
//        _cvUiState.value.name = newName
        _cvUiState.update { currentState ->
            currentState.copy(
                fullName = newName,
                userName = userName,
                githubHandle = githubHandle,
                personalBio = personalBio
            )
        }
    }

    */


    fun updateFullName(name: String){
        _cvUiState.update { currentState ->
            currentState.copy(fullName = name)
        }
    }
    fun updateUserName(name: String){
        _cvUiState.update { currentState ->
            currentState.copy(userName = name)
        }
    }
    fun updateGithubHandle(handle: String){
        _cvUiState.update { currentState ->
            currentState.copy(githubHandle = handle)
        }
    }
    fun updatePersonalBio(bio: String){
        _cvUiState.update { currentState ->
            currentState.copy(personalBio = bio)
        }
    }


}