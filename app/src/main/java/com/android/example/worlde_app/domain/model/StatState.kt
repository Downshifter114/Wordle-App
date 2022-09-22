package com.android.example.worlde_app.domain.model

data class StatState(
    var gamesPlayed: Int = 0,
    var gamesWon: Int = 0,
    var winPercentage: Int = 0,
    var currentStreak: Int = 0,
    var maxStreak: Int = 0,
)
