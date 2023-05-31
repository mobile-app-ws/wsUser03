package com.example.worldskills_app.ui.screens.onboard

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.worldskills_app.R
import org.koin.androidx.compose.getViewModel

@Composable
fun OnBoardScreen(
    modifier: Modifier = Modifier,
    onSwipe: () -> Unit = {},
    onCancel: () -> Unit = {},
    viewModel: OnBoardViewModel = getViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
    ) {
        DefaultFon(
            isNowSwipe = state.nowPosistion != Position.three,
            onSwipe = {
                onSwipe()
            },
            onCancel = onCancel
        )
    }
}

@Composable
fun DefaultFon(
    modifier: Modifier = Modifier,
    isNowSwipe: Boolean = false,
    @DrawableRes iconId: Int = R.drawable.logo,
    onSwipe: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                modifier = Modifier.padding(start = 30.dp),
                onClick = {
                    if (isNowSwipe) {
                        onSwipe()
                    } else {
                        onCancel()
                    }
                }
            ) {
                Text(
                    text = if (isNowSwipe) {
                        "Пропустить"
                    } else {
                        "Завершить"
                    },
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.shape),
                contentDescription = null
            )
        }

        Image(
            modifier = Modifier,
            painter = painterResource(id = iconId),
            contentDescription = null
        )
    }
}