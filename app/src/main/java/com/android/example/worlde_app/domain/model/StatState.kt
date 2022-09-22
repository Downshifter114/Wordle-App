package com.android.example.worlde_app.domain.model

data class StatState(
    val gamesPlayed: Int = 0,
    val gamesWon: Int = 0,
    val winPercentage: Int = 0,
    val currentStreak: Int = 0,
    val maxStreak: Int = 0,
)
