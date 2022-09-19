package com.android.example.worlde_app.domain.model

data class PopUpStates(
    var how_to_play: Boolean = true,
    var stats: Boolean = false,
    var settings: Boolean = false,
    var win: Boolean = false,
    var lose: Boolean = false
)
