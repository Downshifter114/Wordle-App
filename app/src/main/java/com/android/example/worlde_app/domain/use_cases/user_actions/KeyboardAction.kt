package com.android.example.worlde_app.domain.use_cases.user_actions

sealed class KeyboardAction {
    data class AddLetter(val letter: String): KeyboardAction()
    object Delete: KeyboardAction()
    object Submit: KeyboardAction()
    object ToggleHowToPlay: KeyboardAction()
    object ToggleStats : KeyboardAction()
    object ToggleWin : KeyboardAction()
    object ToggleLose : KeyboardAction()
    object ResetStats : KeyboardAction()
}
