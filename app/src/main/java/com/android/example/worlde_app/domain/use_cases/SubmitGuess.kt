package com.android.example.worlde_app.domain.use_cases

import android.os.Handler
import android.os.Looper
import com.android.example.worlde_app.commons.GlobalStates.POP_UP_STATE
import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.util.Constants.ACTUAL_WORD
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR
import com.android.example.worlde_app.domain.util.Constants.KEY_COLOR
import com.android.example.worlde_app.domain.util.Constants.KEY_SYMBOL_LIST
import com.android.example.worlde_app.domain.util.Constants.LIST_OF_WORDS
import com.android.example.worlde_app.presentation.ui.theme.WordleDarkGray
import com.android.example.worlde_app.presentation.ui.theme.WordleGreen
import com.android.example.worlde_app.presentation.ui.theme.WordleYellow

class SubmitGuess(
    private val gameRepository: GameRepository
) {
    operator fun invoke() {
        gameRepository.submitGuess()
    }
}