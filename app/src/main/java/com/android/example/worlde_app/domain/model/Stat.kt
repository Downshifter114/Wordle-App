package com.android.example.worlde_app.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stat(
    val gamesPlayed: Int,
    val gamesWon: Int,
    val winPercentage: Int,
    val currentStreak: Int,
    val maxStreak: Int,
    @PrimaryKey val id: Int? = null
)