package com.android.example.worlde_app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.example.worlde_app.commons.GlobalStates.POP_UP_STATE
import com.android.example.worlde_app.commons.GlobalStates.WORDLE_STATE
import com.android.example.worlde_app.domain.use_cases.user_actions.KeyboardAction
import com.android.example.worlde_app.domain.util.Constants.ACTUAL_WORD
import com.android.example.worlde_app.domain.util.Constants.GUESS_SPACING
import com.android.example.worlde_app.domain.util.Constants.KEY_SIZE
import com.android.example.worlde_app.domain.util.Constants.KEY_SPACING
import com.android.example.worlde_app.domain.util.Constants.KEY_SYMBOL_LIST
import com.android.example.worlde_app.domain.util.Constants.LIST_OF_WORDS
import com.android.example.worlde_app.presentation.WordleViewModel
import com.android.example.worlde_app.presentation.ui.theme.WordleBackground
import com.android.example.worlde_app.presentation.ui.theme.WordleDarkGray

@Composable
fun GameScreen(
    modifier: Modifier,
    viewModel: WordleViewModel,
    onAction: (KeyboardAction) -> Unit
) {

    if (POP_UP_STATE.stats) {
        Stats(modifier = modifier, onAction = onAction)
    }
    if (POP_UP_STATE.how_to_play) {
        HowToPlay(modifier = modifier, onAction = onAction)
    }
    if (POP_UP_STATE.win) {
        Win(modifier = modifier)
    }
    if (POP_UP_STATE.lose) {
        Lose(modifier = modifier, actualWord = ACTUAL_WORD)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WordleBackground),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TOP BAR
        TopBar(title = "WordleApp", onAction = onAction)
        Spacer(modifier = Modifier.height(15.dp))

        //GUESS SECTION
        Box(modifier = modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                horizontalAlignment = Alignment.CenterHorizontally
            ) //EACH GUESS WORD
            {
                //guess number: 1
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_one.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_one.letters[i],
                            color = WORDLE_STATE.guess_one.colors[i],
                            borderColor = WORDLE_STATE.guess_one.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
                //guess number: 2
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_two.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_two.letters[i],
                            color = WORDLE_STATE.guess_two.colors[i],
                            borderColor = WORDLE_STATE.guess_two.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
                //guess number: 3
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_three.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_three.letters[i],
                            color = WORDLE_STATE.guess_three.colors[i],
                            borderColor = WORDLE_STATE.guess_three.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
                //guess number: 4
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_four.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_four.letters[i],
                            color = WORDLE_STATE.guess_four.colors[i],
                            borderColor = WORDLE_STATE.guess_four.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
                //guess number: 5
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_five.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_five.letters[i],
                            color = WORDLE_STATE.guess_five.colors[i],
                            borderColor = WORDLE_STATE.guess_five.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
                //guess number: 6
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GUESS_SPACING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in WORDLE_STATE.guess_six.letters.indices)
                        GuessLetterField(
                            letter = WORDLE_STATE.guess_six.letters[i],
                            color = WORDLE_STATE.guess_six.colors[i],
                            borderColor = WORDLE_STATE.guess_six.borderColors[i],
                            modifier = modifier.weight(1f)
                        )
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        //KEYBOARD SECTION
        KeyBoardSection(modifier = modifier, onAction = onAction)

    }
}

//SECTION COMPOSABLE(s)
@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    onAction: (KeyboardAction) -> Unit
) {
    Column {
        Divider(color = WordleDarkGray, thickness = 2.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu icon",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(30.dp))
            Icon(
                imageVector = Icons.Default.Quiz,
                contentDescription = "Question icon",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onAction(KeyboardAction.ToggleHowToPlay) },
            )
            Icon(
                imageVector = Icons.Default.Leaderboard,
                contentDescription = "Stats icon",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onAction(KeyboardAction.ToggleStats) }
            )
        }
        Divider(color = WordleDarkGray, thickness = 2.dp)
    }
}

@Composable
fun KeyBoardSection(
    modifier: Modifier,
    onAction: (KeyboardAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //FIRST ROW QWERTYUIOP
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(KEY_SPACING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (index in 0..9)
            {
                KeyboardKey(
                    symbol = KEY_SYMBOL_LIST[index],
                    id = index, modifier = modifier,
                    size = KEY_SIZE,
                    onClick = { onAction(KeyboardAction.AddLetter(KEY_SYMBOL_LIST[index])) }
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        //SECOND ROW ASDFGHJKL
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            horizontalArrangement = Arrangement.spacedBy(KEY_SPACING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (index in 10..18)
            {
                KeyboardKey(
                    symbol = KEY_SYMBOL_LIST[index],
                    id = index, modifier = modifier,
                    size = KEY_SIZE,
                    onClick = { onAction(KeyboardAction.AddLetter(KEY_SYMBOL_LIST[index])) }
                )
            }
        }
        //THIRD ROW ENTER ZXCVBNM ⌫
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(KEY_SPACING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (index in 19..27)
            {
                when (index) {
                    19 -> KeyboardKey(
                        symbol = KEY_SYMBOL_LIST[index],
                        id = index,
                        modifier = Modifier.aspectRatio(1.2f),

                        size = 67.dp,
                        onClick = { onAction(KeyboardAction.Submit) }
                    )
                    27 -> KeyboardKey(
                        symbol = KEY_SYMBOL_LIST[index],
                        id = index,
                        modifier = Modifier.aspectRatio(1f),

                        size = 60.dp,
                        onClick = { onAction(KeyboardAction.Delete) }
                    )
                    else -> KeyboardKey(
                        symbol = KEY_SYMBOL_LIST[index],
                        id = index,
                        modifier = modifier,

                        size = KEY_SIZE,
                        onClick = { onAction(KeyboardAction.AddLetter(KEY_SYMBOL_LIST[index])) }
                    )
                }
            }
        }
    }
}
