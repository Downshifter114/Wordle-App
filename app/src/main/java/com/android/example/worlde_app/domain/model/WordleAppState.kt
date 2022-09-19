package com.android.example.worlde_app.domain.model

import androidx.compose.ui.graphics.Color
import com.android.example.worlde_app.domain.util.Constants.GUESS_BORDER_COLOR
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR
import com.android.example.worlde_app.domain.util.Constants.KEY_COLOR

data class WordleAppState(
    var guess_one: Guess = Guess(),
    var guess_two: Guess = Guess(),
    var guess_three: Guess = Guess(),
    var guess_four: Guess = Guess(),
    var guess_five: Guess = Guess(),
    var guess_six: Guess = Guess(),
    var keyboard_colors:  List<Color> = List<Color>(28){ KEY_COLOR },
    var listOfWords: List<String> = List<String>(1){"BURAK"},
)

