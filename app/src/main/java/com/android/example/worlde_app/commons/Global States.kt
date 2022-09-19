package com.android.example.worlde_app.commons

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.android.example.worlde_app.domain.model.PopUpStates
import com.android.example.worlde_app.domain.model.WordleAppState

object GlobalStates {
    var WORDLE_STATE by mutableStateOf(WordleAppState())
    var POP_UP_STATE by mutableStateOf(PopUpStates())
}