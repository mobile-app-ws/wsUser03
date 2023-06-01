package com.example.wear.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text
import com.example.wear.R
import com.example.wear.presentation.WSButton
import com.example.wear.presentation.theme.WorldskillsappTheme


@Composable
fun AuthScreen() {
    WorldskillsappTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 16.dp)
                    .padding(top = 43 .dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(end = 9.dp),
                    painter = painterResource(id = R.drawable.emojies),
                    contentDescription = null
                )
                Text(
                    text = "Добро пожаловать!",
                    modifier = Modifier,
                    color = Color.Black,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            WSButton(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = "Вход",
                onClick = {

                }
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}