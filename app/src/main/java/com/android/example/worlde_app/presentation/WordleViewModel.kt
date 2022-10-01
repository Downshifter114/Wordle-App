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

    fun onAction(action: KeyboardAction) {
        when (action) {
            is KeyboardAction.AddLetter -> wordleUseCases.addLetter(action.letter)
            is KeyboardAction.Delete -> wordleUseCases.deleteLetter()
            is KeyboardAction.Submit -> {
                wordleUseCases.submitGuess()

                viewModelScope.launch {
                    var _myStat = statRepository.getStatById(id = 0)
                    //initialize stat id 0 and 1
                    if (_myStat == null)
                        statRepository.insertStat(Stat(0,0,0,0,0,0))
                    _myStat = statRepository.getStatById(id = 0)
                    //games played
                    if (POP_UP_STATE.win || POP_UP_STATE.lose)
                        _myStat = (_myStat!!.copy(gamesPlayed = _myStat!!.gamesPlayed+1))
                    //games won
                    if (POP_UP_STATE.win)
                        _myStat = (_myStat!!.copy(gamesWon = _myStat.gamesWon+1, currentStreak = _myStat.currentStreak+1,
                        maxStreak = if (_myStat.maxStreak < _myStat.currentStreak) _myStat.currentStreak+1 else _myStat.maxStreak))
                    //win percentage
                    if (POP_UP_STATE.win || POP_UP_STATE.lose)
                        _myStat = (_myStat!!.copy(winPercentage = 100*_myStat.gamesWon/_myStat.gamesPlayed))
                    //current streak
                    if (POP_UP_STATE.lose)
                        _myStat = (_myStat!!.copy(currentStreak = 0))

                    var myStat: Stat = Stat(0,0,0,0,0,0)
                    if (_myStat != null)
                        myStat = _myStat

                    statRepository.insertStat(myStat)


                    myStat = statRepository.getStatById(0)!!
                    STATS_STATE = STATS_STATE.copy(
                        gamesPlayed = myStat?.gamesPlayed ?: 0,
                        gamesWon = myStat?.gamesWon ?: 0,
                        winPercentage = myStat?.winPercentage ?: 0,
                        currentStreak = myStat?.currentStreak ?: 0,
                        maxStreak = myStat?.maxStreak ?: 0
                    )
                }
            }
            is KeyboardAction.ToggleHowToPlay -> wordleUseCases.toggleHowToPlay()
            is KeyboardAction.ToggleStats -> {
                viewModelScope.launch {
                    val myStat = statRepository.getStatById(0)
                    STATS_STATE = STATS_STATE.copy(
                        gamesPlayed = myStat?.gamesPlayed ?: 0,
                        gamesWon = myStat?.gamesWon ?: 0,
                        winPercentage = myStat?.winPercentage ?: 0,
                        currentStreak = myStat?.currentStreak ?: 0,
                        maxStreak = myStat?.maxStreak ?: 0
                    )
                }
                wordleUseCases.toggleStats()
            }
            is KeyboardAction.ToggleWin -> wordleUseCases.toggleWin()
            is KeyboardAction.ToggleLose -> wordleUseCases.toggleLose()
            is KeyboardAction.ResetStats -> {
                viewModelScope.launch {
                    val limitedMode = statRepository.getStatById(id = 0)
                    if (limitedMode != null)
                        statRepository.deleteStat(limitedMode)
                    STATS_STATE = STATS_STATE.copy(
                        gamesPlayed = 0,
                        gamesWon = 0,
                        winPercentage = 0,
                        currentStreak = 0,
                        maxStreak = 0
                    )
                }
            }
        }
    }
}