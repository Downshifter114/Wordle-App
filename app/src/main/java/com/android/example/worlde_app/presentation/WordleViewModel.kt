package com.android.example.worlde_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.example.worlde_app.domain.repository.DictionaryRepository
import com.android.example.worlde_app.domain.use_cases.*
import com.android.example.worlde_app.domain.use_cases.user_actions.KeyboardAction
import com.android.example.worlde_app.domain.util.Constants.LIST_OF_WORDS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordleViewModel @Inject constructor(
    private val wordleUseCases: WordleUseCases,
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {

    fun assignWordPool() {
        viewModelScope.launch {
            LIST_OF_WORDS = dictionaryRepository.getWords()
        }
    }

    fun onAction(action: KeyboardAction) {
        when (action) {
            is KeyboardAction.AddLetter -> wordleUseCases.addLetter(action.letter)
            is KeyboardAction.Delete -> wordleUseCases.deleteLetter()
            is KeyboardAction.Submit -> wordleUseCases.submitGuess()
            is KeyboardAction.ToggleHowToPlay -> wordleUseCases.toggleHowToPlay()
            is KeyboardAction.ToggleStats -> wordleUseCases.toggleStats()
            is KeyboardAction.ToggleWin -> wordleUseCases.toggleWin()
            is KeyboardAction.ToggleLose -> wordleUseCases.toggleLose()
        }
    }
}