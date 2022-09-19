package com.android.example.worlde_app.domain.use_cases

import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR

class DeleteLetter(
    private val gameRepository: GameRepository
) {
    operator fun invoke() {
        gameRepository.deleteLetter()
    }
}