package com.android.example.worlde_app.domain.use_cases

import com.android.example.worlde_app.commons.GlobalStates
import com.android.example.worlde_app.domain.repository.GameRepository

class ToggleWin(
    private val gameRepository: GameRepository
) {
    operator fun invoke() {
        gameRepository.toggleWin()
    }
}