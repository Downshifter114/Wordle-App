package com.android.example.worlde_app.domain.use_cases

data class WordleUseCases(
    val addLetter: AddLetter,
    val deleteLetter: DeleteLetter,
    val submitGuess: SubmitGuess,
    val toggleHowToPlay: ToggleHowToPlay,
    val toggleLose: ToggleLose,
    val toggleStats: ToggleStats,
    val toggleWin: ToggleWin,
)
