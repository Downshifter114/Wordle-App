package com.android.example.worlde_app.presentation

import androidx.lifecycle.ViewModel
import com.android.example.worlde_app.domain.use_cases.*
import com.android.example.worlde_app.domain.use_cases.user_actions.KeyboardAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordleViewModel @Inject constructor(
    private val wordleUseCases: WordleUseCases
) : ViewModel() {
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