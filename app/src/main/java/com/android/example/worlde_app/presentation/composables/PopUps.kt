package com.android.example.worlde_app.presentation.composables

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.android.example.worlde_app.commons.GlobalStates.STATS_STATE
import com.android.example.worlde_app.domain.use_cases.user_actions.KeyboardAction
import com.android.example.worlde_app.presentation.ui.theme.*

@Composable
fun HowToPlay(
    modifier: androidx.compose.ui.Modifier,
    onAction: (KeyboardAction) -> Unit
) {
    Popup {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(WordleBackground)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //Top bar
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "HOW TO PLAY", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text(text = "✖", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = modifier
                        .clickable { onAction(KeyboardAction.ToggleHowToPlay) })
                }
                //Guide Text
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier.padding(horizontal = 20.dp)
                ) {
                    Text(text = "Guess the WORDLE in 6 tries.", color = Color.White, fontSize = 18.sp)
                    Text(text = "Each guess must be a valid 5-letter word. Hit the enter button to submit.", color = Color.White, fontSize = 18.sp)
                    Text(text = "After each guess, the color of the tiles will change to show how close your guess was to the word.", color = Color.White, fontSize = 18.sp)
                }

                //Examples
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = "Examples", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    //Weary
                    Row(
                        modifier = modifier.width(300.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleGreen)
                                .background(WordleGreen)
                                .weight(1f)
                        ) {
                            Text(text = "W", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "E", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "A", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "R", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "Y", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }

                    }
                    Text(text = "The letter W is in the word an in the correct spot.", color = Color.White, fontSize = 18.sp)
                    //Pills
                    Row(
                        modifier = modifier.width(300.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "P", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleYellow)
                                .background(WordleYellow)
                                .weight(1f)
                        ) {
                            Text(text = "I", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "L", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "L", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "S", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }

                    }
                    Text(text = "The letter I is in the word but in the wrong spot.", color = Color.White, fontSize = 18.sp)
                    //Vague
                    Row(
                        modifier = modifier.width(300.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "V", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "A", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "G", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleDarkGray)
                                .weight(1f)
                        ) {
                            Text(text = "U", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }
                        Box(
                            modifier = modifier
                                .aspectRatio(1f)
                                .border(2.dp, WordleDarkGray)
                                .background(WordleBackground)
                                .weight(1f)
                        ) {
                            Text(text = "E", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 42.sp, modifier = modifier
                                .align(Alignment.Center))
                        }

                    }
                    Text(text = "The letter U is not in the word in any spot..", color = Color.White, fontSize = 18.sp)

                }
                //Info
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.padding(horizontal = 20.dp)
                ) {
                    Text(text = "A new WORDLE will be available each day!", color = Color.White,fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Justify)
                    Text(text = "You can send today's results to your friends.", color = Color.White, fontSize = 18.sp)
                    Spacer(modifier = modifier.height(5.dp))
                    Text(text = "If you've done today's wordle, you can always choose 'Unlimited Wordle' option in the menu and keep playing.", color = Color.White,fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Justify)
                    Text(text = "Good luck! Have fun!", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}


@Composable
fun Stats(
    modifier: androidx.compose.ui.Modifier,
    onAction: (KeyboardAction) -> Unit
) {
    Popup {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(PopUpBlack)
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(35.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //Top bar
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "STATISTICS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Text(text = "✖", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = modifier
                        .clickable { onAction(KeyboardAction.ToggleStats) })
                }
                //Numbers
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = STATS_STATE.gamesPlayed.toString(), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 36.sp)
                        Text(text = "Played\n", color = Color.White, fontSize = 18.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = STATS_STATE.winPercentage.toString(), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 36.sp)
                        Text(text = "Win %\n", color = Color.White, fontSize = 18.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = STATS_STATE.currentStreak.toString(), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 36.sp)
                        Text(text = "Current\nStreak", color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = STATS_STATE.maxStreak.toString(), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 36.sp)
                        Text(text = "Max\nStreak", color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
                    }
                }
                //Guess Distribution
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "GUESS DISTRIBUTION", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    Spacer(modifier = modifier.height(15.dp))
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "1", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "0", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 15.dp))
                    }
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "2", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "0", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 15.dp))
                    }
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "3", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "2", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 45.dp))
                    }
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "4", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "0", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 15.dp))
                    }
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "5", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "1", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 30.dp))
                    }
                    Row(modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),horizontalArrangement = Arrangement.Start) {
                        Text(text = "6", color = Color.White, fontSize = 24.sp)
                        Spacer(modifier = modifier.width(15.dp))
                        Text(text = "1", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .background(WordleLightGray)
                                .padding(horizontal = 30.dp))
                    }
                }
                //Info
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "NEXT WORDLE", color = Color.White,fontSize = 18.sp, textAlign = TextAlign.Center)
                    Text(text = "12:54:22", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 36.sp)
                    Spacer(modifier = modifier.height(15.dp))
                }
                //Buttons
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(vertical = 10.dp)
                ) {
                    Box(modifier = modifier
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, Color.White, RoundedCornerShape(12.dp))
                        .weight(1f)
                        .padding(vertical = 7.dp)
                    ) {
                        Text(text = "Unlimited Wordle", fontSize = 18.sp, color = Color.White,
                            modifier = modifier.align(Alignment.Center))
                    }
                    Spacer(modifier = modifier.width(10.dp))
                    Box(modifier = modifier
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, WordleGreen, RoundedCornerShape(12.dp))
                        .background(WordleGreen)
                        .weight(1f)
                        .padding(vertical = 7.dp)
                    ) {
                        Text(text = "Share", fontSize = 18.sp, color = Color.White,
                            modifier = modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}


@Composable
fun Win(
    modifier: androidx.compose.ui.Modifier,
) {
    Popup(alignment = Alignment.TopCenter) {
        Box(
            modifier = modifier
                .padding(top = 45.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Genius", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun Lose(
    modifier: androidx.compose.ui.Modifier,
    actualWord: String
) {
    Popup(alignment = Alignment.TopCenter) {
        Box(
            modifier = modifier
                .padding(top = 45.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = actualWord, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 24.sp,modifier = modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun Prev() {
    val modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
    HowToPlay(modifier = modifier, onAction = {return@HowToPlay})
}