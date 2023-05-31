package com.example.worldskills_app.ui.screens.requaidsms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun BlockRequiredSms(
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Box(
        modifier = modifier
            .requiredSize(46.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = Color(0xFFF5F5F9)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFEBEBEB),
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun PreviewBlockRequiredSms() {
    BlockRequiredSms(text = "2")
}


@Composable
fun RequiredSmsScreen(
    modifier: Modifier = Modifier,
    viewModel: RequiredSmsViewModel = getViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            repeat(4){index->
                BlockRequiredSms(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = state.code.getOrNull(index)?.toString() ?: ""
                )
            }
        }
    }
}