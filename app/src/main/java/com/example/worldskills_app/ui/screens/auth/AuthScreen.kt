package com.example.worldskills_app.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskills_app.R
import com.example.worldskills_app.ui.screens.WSButton
import com.example.worldskills_app.ui.screens.WSTextField
import com.example.worldskills_app.ui.screens.toast
import de.palm.composestateevents.EventEffect
import org.koin.androidx.compose.getViewModel

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    onGoNext: () -> Unit = {},
    viewModel: AuthViewModel = getViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    EventEffect(
        event = state.errorEvent,
        onConsumed = viewModel::onConsumedErrorEvent
    ) {
        toast(
            text = state.error,
            context = context
        )
    }

    EventEffect(
        event = state.onGoNext,
        onConsumed =viewModel::onConsumedGoNextEvent
    ){
        onGoNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .align(Alignment.TopCenter)
                .imePadding()
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 23.dp, top = 60.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.emojies),
                    contentDescription = null
                )
                Text(
                    text = "Добро пожаловать!",
                    modifier = Modifier,
                    color = Color.Black,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 64.dp),
                color = Color.Black,
                lineHeight = 20.sp,
                overflow = TextOverflow.Visible
            )
            WSTextField(
                modifier = Modifier
                    .padding(bottom = 32.dp),
                title = "Вход по E-mail",
                onValueChange = { str ->
                    viewModel.setEmail(str)
                },
                placeholder = "example@mail.ru",
                text = state.email
            )
            WSButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Далее",
                onClick = {
                    viewModel.onSendSmsCode()
                },
                enabled = state.email.isNotEmpty()
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Или войдите с помощью",
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        //TODO
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .sizeIn(minWidth = 50.dp),
                    text = "Войти с Яндекс",
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}