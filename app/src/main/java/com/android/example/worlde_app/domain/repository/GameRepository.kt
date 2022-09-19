package com.android.example.worlde_app.domain.repository

import com.android.example.worlde_app.domain.use_cases.DeleteLetter
import com.android.example.worlde_app.domain.use_cases.ToggleHowToPlay

interface GameRepository {

    fun addLetter(letter: String)

    fun deleteLetter()

    fun submitGuess()

    fun toggleHowToPlay()

    fun toggleLose()

    fun toggleStats()

    fun toggleWin()
}