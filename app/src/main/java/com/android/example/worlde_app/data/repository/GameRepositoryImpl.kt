package com.android.example.worlde_app.data.repository

import android.os.Handler
import android.os.Looper
import com.android.example.worlde_app.commons.GlobalStates
import com.android.example.worlde_app.domain.repository.GameRepository
import com.android.example.worlde_app.domain.util.Constants
import com.android.example.worlde_app.presentation.ui.theme.WordleDarkGray
import com.android.example.worlde_app.presentation.ui.theme.WordleGreen
import com.android.example.worlde_app.presentation.ui.theme.WordleYellow

class GameRepositoryImpl: GameRepository {
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
                else -> GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(letters = listOf(list[0], list[1], list[2], list[3], letter)))
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
        val listOfKeys = Constants.KEY_SYMBOL_LIST
        val listOfWords = Constants.LIST_OF_WORDS
        val actualWord = Constants.ACTUAL_WORD
        //if we're on the first guess
        if (GlobalStates.WORDLE_STATE.guess_one.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_one.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_one.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_one.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()


            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_one = GlobalStates.WORDLE_STATE.guess_one.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the second guess
        if (GlobalStates.WORDLE_STATE.guess_two.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_two.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_two.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_two.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()

            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else{
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_two = GlobalStates.WORDLE_STATE.guess_two.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the third guess
        if (GlobalStates.WORDLE_STATE.guess_three.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_three.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_three.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_three.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()

            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else
                        {
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_three = GlobalStates.WORDLE_STATE.guess_three.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the fourth guess
        if (GlobalStates.WORDLE_STATE.guess_four.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_four.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_four.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_five.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()

            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_four = GlobalStates.WORDLE_STATE.guess_four.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                }
            }

        }
        check()
        //if we're on the fifth guess
        if (GlobalStates.WORDLE_STATE.guess_five.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_five.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_five.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_five.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()

            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_five = GlobalStates.WORDLE_STATE.guess_five.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                }
            }
        }
        check()
        //if we're on the sixth guess
        if (GlobalStates.WORDLE_STATE.guess_six.colors == List(5){ Constants.GUESS_COLOR }){
            val list = GlobalStates.WORDLE_STATE.guess_six.letters
            val colorList = GlobalStates.WORDLE_STATE.guess_six.colors.toMutableList()
            val borderColorList = GlobalStates.WORDLE_STATE.guess_six.borderColors.toMutableList()
            val keyboardColorList = GlobalStates.WORDLE_STATE.keyboard_colors.toMutableList()
            var guessWord: String = list.joinToString("")
            guessWord = guessWord.lowercase()

            //if it's not an actual word
            if (!listOfWords.contains(guessWord))
                return

            //detecting algorithm
            for (i in list.indices)
            {
                if (actualWord.contains(list[i]))
                {
                    if (list[i] == actualWord[i].toString())
                    {
                        colorList[i] = WordleGreen
                        borderColorList[i] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(colors = colorList, borderColors = borderColorList))
                        keyboardColorList[listOfKeys.indexOf(list[i])] = WordleGreen
                        GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                    }
                    else
                    {
                        var vibeCheck = true
                        if (i != 0)
                        {
                            for (j in i-1 downTo 0)
                            {
                                if (list[j] == list[i])
                                {
                                    vibeCheck = false
                                    if (howManyAppearances(list[i], actualWord) == howManyAppearances(list[i], list.joinToString("")))
                                        vibeCheck = true
                                }
                            }
                        }
                        if (vibeCheck)
                        {
                            colorList[i] = WordleYellow
                            borderColorList[i] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(colors = colorList, borderColors = borderColorList))
                            if (keyboardColorList[listOfKeys.indexOf(list[i])] == Constants.KEY_COLOR) keyboardColorList[listOfKeys.indexOf(list[i])] = WordleYellow
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
                        }
                        else {
                            colorList[i] = WordleDarkGray
                            GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(colors = colorList))
                        }
                    }
                }
                else {
                    colorList[i] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(guess_six = GlobalStates.WORDLE_STATE.guess_six.copy(colors = colorList))
                    keyboardColorList[listOfKeys.indexOf(list[i])] = WordleDarkGray
                    GlobalStates.WORDLE_STATE = GlobalStates.WORDLE_STATE.copy(keyboard_colors = keyboardColorList)
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
        if (GlobalStates.WORDLE_STATE.guess_one.colors == winList || GlobalStates.WORDLE_STATE.guess_one.colors == winList || GlobalStates.WORDLE_STATE.guess_two.colors == winList || GlobalStates.WORDLE_STATE.guess_three.colors == winList || GlobalStates.WORDLE_STATE.guess_four.colors == winList|| GlobalStates.WORDLE_STATE.guess_five.colors == winList|| GlobalStates.WORDLE_STATE.guess_six.colors == winList)
            GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(win = !GlobalStates.POP_UP_STATE.win)
        else if(GlobalStates.WORDLE_STATE.guess_six.colors != List(5){ Constants.GUESS_COLOR })
            GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(lose = !GlobalStates.POP_UP_STATE.lose)

        //TOGGLE WIN ACTION
        if (GlobalStates.POP_UP_STATE.win) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(win = false)
                GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(stats = true)
            }, 3000)
        }
        if (GlobalStates.POP_UP_STATE.lose) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(lose = false)
                GlobalStates.POP_UP_STATE = GlobalStates.POP_UP_STATE.copy(stats = true)
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