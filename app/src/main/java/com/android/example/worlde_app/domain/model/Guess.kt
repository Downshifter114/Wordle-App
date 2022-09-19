package com.android.example.worlde_app.domain.model

import androidx.compose.ui.graphics.Color
import com.android.example.worlde_app.domain.util.Constants.GUESS_BORDER_COLOR
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR

data class Guess(
    var letters: List<String> = List<String>(5){ " " },
    var colors: List<Color> = List<Color>(5){ GUESS_COLOR },
    var borderColors: List<Color> = List<Color>(5){ GUESS_BORDER_COLOR }
)
