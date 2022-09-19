package com.android.example.worlde_app.domain.use_cases

import com.android.example.worlde_app.commons.GlobalStates.POP_UP_STATE
import com.android.example.worlde_app.domain.repository.GameRepository

class ToggleHowToPlay(
    private val gameRepository: GameRepository
) {
    operator fun invoke() {
        gameRepository.toggleHowToPlay()
    }
}