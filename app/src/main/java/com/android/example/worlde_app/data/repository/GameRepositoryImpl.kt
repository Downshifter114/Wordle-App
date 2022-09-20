package com.android.example.worlde_app.data.repository

import android.os.Handler
import android.os.Looper
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import com.android.example.worlde_app.commons.GlobalStates
import com.android.example.worlde_app.commons.GlobalStates.POP_UP_STATE
import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.util.Constants
import com.android.example.worlde_app.domain.util.Constants.ACTUAL_WORD
import com.android.example.worlde_app.domain.util.Constants.GUESS_COLOR
import com.android.example.worlde_app.domain.util.Constants.KEY_SYMBOL_LIST
import com.android.example.worlde_app.domain.util.Constants.LIST_OF_WORDS
import com.android.example.worlde_app.presentation.ui.theme.*

class GameRepositoryImpl: GameRepository {
    var counter = 0
    override fun addLetter(letter: String) {
        //for the first guess (if the last letter of first guess is empty)
        if (GlobalStates.WORDLE_STATE.guess_one.letters[4] == " ")
        {
            val list = GlobalStates.WORDLE_STATE.guess_one.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_one.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> WORDLE_STATE.copy(guess_one = WORDLE_STATE.guess_one.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
        //for the second guess
        if (GlobalStates.WORDLE_STATE.guess_two.letters[4] == " " && GlobalStates.WORDLE_STATE.guess_one.colors != List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_two.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_two.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
        //for the third guess
        if (GlobalStates.WORDLE_STATE.guess_three.letters[4] == " " && GlobalStates.WORDLE_STATE.guess_two.colors != List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_three.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_three.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
        //for the fourth guess
        if (GlobalStates.WORDLE_STATE.guess_four.letters[4] == " " && GlobalStates.WORDLE_STATE.guess_three.colors != List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_four.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_four.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
        //for the fifth guess
        if (GlobalStates.WORDLE_STATE.guess_five.letters[4] == " " && GlobalStates.WORDLE_STATE.guess_four.colors != List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_five.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_five.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
        //for the sixth guess
        if (GlobalStates.WORDLE_STATE.guess_six.letters[4] == " " && GlobalStates.WORDLE_STATE.guess_five.colors != List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_six.letters
            GlobalStates.WORDLE_STATE = when (GlobalStates.WORDLE_STATE.guess_six.letters) {
                listOf(" ", " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = listOf(letter, " ", " ", " ", " ")))
                listOf(list[0], " ", " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = listOf(list[0], letter, " ", " ", " ")))
                listOf(list[0], list[1], " ", " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = listOf(list[0], list[1], letter, " ", " ")))
                listOf(list[0], list[1], list[2], " ", " ") -> GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = listOf(list[0], list[1], list[2], letter, " ")))
                else -> GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
            }
            return
        }
    }

    override fun deleteLetter() {
        //if we're on the first guess
        if (GlobalStates.WORDLE_STATE.guess_one.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_one.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_one.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = list))
                    return
                }
            }
        }
        //if we're on the second guess
        if (GlobalStates.WORDLE_STATE.guess_two.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_two.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_two.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(letters = list))
                    return
                }
            }
        }
        //if we're on the third guess
        if (GlobalStates.WORDLE_STATE.guess_three.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_three.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_three.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(letters = list))
                    return
                }
            }
        }
        //if we're on the fourth guess
        if (GlobalStates.WORDLE_STATE.guess_four.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_four.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_four.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(letters = list))
                    return
                }
            }

        }
        //if we're on the fifth guess
        if (GlobalStates.WORDLE_STATE.guess_five.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_five.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_five.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(letters = list))
                    return
                }
            }
        }
        //if we're on the sixth guess
        if (GlobalStates.WORDLE_STATE.guess_six.colors == List(5){ Constants.GUESS_COLOR })
        {
            val list = GlobalStates.WORDLE_STATE.guess_six.letters.toMutableList()
            for (i in GlobalStates.WORDLE_STATE.guess_six.letters.indices.reversed())
            {
                if (list[i] != " ")
                {
                    list[i] = " "
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(letters = list))
                    return
                }
            }
        }
    }

    override fun submitGuess() {
        //if we're on the first guess
        if (WORDLE_STATE.guess_one.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_one.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_one.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_one = WORDLE_STATE.guess_one.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], guessWord))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_one = WORDLE_STATE.guess_one.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_one = WORDLE_STATE.guess_one.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_one = WORDLE_STATE.guess_one.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the second guess
        if (WORDLE_STATE.guess_two.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_two.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_two.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_two = WORDLE_STATE.guess_two.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], list.joinToString { "" }))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_two = WORDLE_STATE.guess_two.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_two = WORDLE_STATE.guess_two.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_two = WORDLE_STATE.guess_two.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the third guess
        if (WORDLE_STATE.guess_three.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_three.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_three.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_three = WORDLE_STATE.guess_three.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], list.joinToString { "" }))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_three = WORDLE_STATE.guess_three.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_three = WORDLE_STATE.guess_three.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_three = WORDLE_STATE.guess_three.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the fourth guess
        if (WORDLE_STATE.guess_four.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_four.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_four.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_four = WORDLE_STATE.guess_four.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], list.joinToString { "" }))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_four = WORDLE_STATE.guess_four.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_four = WORDLE_STATE.guess_four.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_four = WORDLE_STATE.guess_four.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the fifth guess
        if (WORDLE_STATE.guess_five.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_five.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_five.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_five = WORDLE_STATE.guess_five.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], list.joinToString { "" }))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_five = WORDLE_STATE.guess_five.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_five = WORDLE_STATE.guess_five.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_five = WORDLE_STATE.guess_five.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the sixth guess
        if (WORDLE_STATE.guess_six.colors == List(5){ WordleBackground}) {
            val list = WORDLE_STATE.guess_six.letters.toMutableList()
            var guessWord: String = list[0] + list[1] + list[2] + list[3] + list[4]
            guessWord = guessWord.lowercase(); ACTUAL_WORD = ACTUAL_WORD.lowercase()
            val colorList = WORDLE_STATE.guess_six.colors.toMutableList()
            val keyboardColorList = WORDLE_STATE.keyboard_colors.toMutableList()

            if (!LIST_OF_WORDS.contains(guessWord))
                return

            for (i in list.indices)
            {
                if (ACTUAL_WORD.contains((guessWord[i])))
                {
                    if (guessWord[i] == ACTUAL_WORD[i])
                    {
                        colorList[i] = WordleGreen
                        keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleGreen
                        WORDLE_STATE = WORDLE_STATE.copy(guess_six = WORDLE_STATE.guess_six.copy(colors = colorList, borderColors = colorList), keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if ( i!= 0)
                        {
                            for (j in i-1 downTo  0)
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], ACTUAL_WORD) == howManyAppearances(list[i], list.joinToString { "" }))
                                        vibeCheck = true
                                }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            WORDLE_STATE = WORDLE_STATE.copy(guess_six = WORDLE_STATE.guess_six.copy(colors = colorList, borderColors = colorList))
                            if (keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] == WordleLightGray)
                            {
                                keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleYellow
                                WORDLE_STATE = WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                            }
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            WORDLE_STATE = WORDLE_STATE.copy(guess_six = WORDLE_STATE.guess_six.copy(colors = colorList))
                        }
                    }

                }
                else {
                    colorList[i] = WordleDarkGray
                    keyboardColorList[KEY_SYMBOL_LIST.indexOf(list[i])] = WordleDarkGray
                    WORDLE_STATE = WORDLE_STATE.copy(guess_six = WORDLE_STATE.guess_six.copy(colors = colorList), keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
    }

    override fun toggleHowToPlay() {
        GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(how_to_play = !GlobalStates.POP_UP_STATE.how_to_play)
    }

    override fun toggleLose() {
        GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(lose = !GlobalStates.POP_UP_STATE.lose)
    }

    override fun toggleStats() {
        GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(stats = !GlobalStates.POP_UP_STATE.stats)
    }

    override fun toggleWin() {
        GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(win = !GlobalStates.POP_UP_STATE.win)
    }

    //Helper functions
    private fun check() {
        val winList = List(5){WordleGreen}
        //Check if they win
        if (WORDLE_STATE.guess_one.colors == winList || WORDLE_STATE.guess_one.colors == winList || WORDLE_STATE.guess_two.colors == winList || WORDLE_STATE.guess_three.colors == winList || WORDLE_STATE.guess_four.colors == winList|| WORDLE_STATE.guess_five.colors == winList|| WORDLE_STATE.guess_six.colors == winList)
            POP_UP_STATE = POP_UP_STATE.copy(win = !POP_UP_STATE.win)
        else if(WORDLE_STATE.guess_six.colors != List(5){ GUESS_COLOR })
            POP_UP_STATE = POP_UP_STATE.copy(lose = !POP_UP_STATE.lose)

        //TOGGLE WIN ACTION
        if (POP_UP_STATE.win) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                POP_UP_STATE = POP_UP_STATE.copy(win = false)
                POP_UP_STATE = POP_UP_STATE.copy(stats = true)
            }, 3000)
        }
        if (POP_UP_STATE.lose) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                POP_UP_STATE = POP_UP_STATE.copy(lose = false)
                POP_UP_STATE = POP_UP_STATE.copy(stats = true)
            }, 3000)
        }
    }

    private fun howManyAppearances(letter: String, list: String): Int {
        var counter = 0
        for (i in list)
        {
            if (i.toString() == letter)
                counter++
        }
        return counter
    }
}