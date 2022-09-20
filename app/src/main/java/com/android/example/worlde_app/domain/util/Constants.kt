package com.android.example.worlde_app.domain.util

import androidx.compose.ui.unit.dp
import com.android.example.worlde_app.presentation.ui.theme.WordleBackground
import com.android.example.worlde_app.presentation.ui.theme.WordleDarkGray
import com.android.example.worlde_app.presentation.ui.theme.WordleLightGray

object Constants {
    val GUESS_COLOR = WordleBackground
    val GUESS_BORDER_COLOR = WordleDarkGray
    val KEY_COLOR = WordleLightGray
    val GUESS_SPACING = 8.dp
    val KEY_SPACING = 2.5.dp
    val KEY_SYMBOL_LIST = listOf("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L",
        "ENTER", "Z", "X", "C", "V", "B", "N", "M", "⌫")
    val KEY_SIZE = 35.dp
    var LIST_OF_WORDS = List<String>(9407){""}
    var ACTUAL_WORD = "CLEAN"
}