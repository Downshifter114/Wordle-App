package com.android.example.worlde_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.example.worlde_app.commons.GlobalStates.POP_UP_STATE
import com.android.example.worlde_app.commons.GlobalStates.STATS_STATE
import com.android.example.worlde_app.domain.model.Stat
import com.android.example.worlde_app.domain.repository.DictionaryRepository
import com.android.example.worlde_app.domain.repository.StatRepository
import com.android.example.worlde_app.domain.use_cases.*
import com.android.example.worlde_app.domain.use_cases.user_actions.KeyboardAction
import com.android.example.worlde_app.domain.util.Constants.LIST_OF_WORDS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.max

@HiltViewModel
class WordleViewModel @Inject constructor(
    private val wordleUseCases: WordleUseCases,
    private val dictionaryRepository: DictionaryRepository,
    private val statRepository: StatRepository
) : ViewModel() {

    fun assignWordPool() {
        viewModelScope.launch {
            LIST_OF_WORDS = dictionaryRepository.getWords()
        }
    }

    fun createStatDatabase() {
        viewModelScope.launch {
            if (statRepository.getStatById(0) == null)
                statRepository.insertStat(Stat(0,0,0,0, 0, 0))
            else if (statRepository.getStatById(1) == null)
                statRepository.insertStat(Stat(0,0,0,0, 0,0))
        }
    }

    fun onAction(action: KeyboardAction) {
        when (action) {
            is KeyboardAction.AddLetter -> wordleUseCases.addLetter(action.letter)
            is KeyboardAction.Delete -> wordleUseCases.deleteLetter()
            is KeyboardAction.Submit -> {
                wordleUseCases.submitGuess()
                viewModelScope.launch {
                    if (POP_UP_STATE.win) {
                        val previous = statRepository.getStatById(0)
                        statRepository.insertStat(previous!!.copy(
                            gamesPlayed = previous!!.gamesPlayed+1,
                            gamesWon = previous.gamesWon+1,
                            winPercentage = 100*previous.gamesWon/previous.gamesPlayed,
                            currentStreak = previous.currentStreak+1,
                            maxStreak = if (previous.maxStreak < previous.currentStreak+1) previous.currentStreak else previous.maxStreak,

                        ))
                    }
                    else if (POP_UP_STATE.lose) {
                        val previous = statRepository.getStatById(0)
                        statRepository.insertStat(Stat(
                            gamesPlayed = previous!!.gamesPlayed+1,
                            gamesWon = previous.gamesWon,
                            winPercentage = 100*previous.gamesWon/previous.gamesPlayed,
                            currentStreak = 0,
                            maxStreak = previous.maxStreak,
                        ))
                    }
                }
            }
            is KeyboardAction.ToggleHowToPlay -> wordleUseCases.toggleHowToPlay()
            is KeyboardAction.ToggleStats -> wordleUseCases.toggleStats()
            is KeyboardAction.ToggleWin -> wordleUseCases.toggleWin()
            is KeyboardAction.ToggleLose -> wordleUseCases.toggleLose()
        }



    }
}