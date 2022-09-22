package com.android.example.worlde_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.example.worlde_app.presentation.composables.GameScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<WordleViewModel>()
            viewModel.assignWordPool()
            GameScreen(modifier = Modifier, viewModel = viewModel, onAction = viewModel::onAction)
        }
    }
}

