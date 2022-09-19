package com.android.example.worlde_app.domain.use_cases

import androidx.compose.runtime.MutableState
import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.domain.model.WordleAppState
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR

class AddLetter(
    private val gameRepository: GameRepository
) {
    operator fun invoke(letter: String) {
        gameRepository.addLetter(letter)
    }
}