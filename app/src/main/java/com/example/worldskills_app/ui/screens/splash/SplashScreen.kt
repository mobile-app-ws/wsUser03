package com.example.worldskills_app.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.worldskills_app.R
import de.palm.composestateevents.EventEffect
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen(
    onGoNext: () -> Unit = {},
    onGoBoard: () -> Unit = {},
    viewModel: SplashViewModel = getViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    EventEffect(
        event = state.isGoNextEventEffect,
        onConsumed = {
            viewModel.onNextConsumed()
        }
    ) {
        onGoNext()
    }

    EventEffect(
        event = state.isGoOnBoarEventEffect,
        onConsumed = {
            viewModel.onBoardConsumed()
        }
    ) {
        onGoBoard()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_font),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Image(
            modifier = Modifier
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
    }
}