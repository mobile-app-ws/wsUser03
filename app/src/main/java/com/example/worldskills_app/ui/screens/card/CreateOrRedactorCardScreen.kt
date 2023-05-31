package com.example.worldskills_app.ui.screens.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.worldskills_app.ui.screens.toast
import de.palm.composestateevents.EventEffect
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateOrRedactorCardScreen(
    modifier: Modifier = Modifier,
    onGoNext: () -> Unit = {},
    viewModel: CreateOrRedactorCardViewModel = getViewModel()
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
        event = state.saveEvent,
        onConsumed = viewModel::onConsumedSaveEvent
    ) {
        //TODO
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Создание карты пациента")
            TextButton(
                modifier = Modifier.padding(start = 30.dp),
                onClick = {
                    onGoNext()
                }
            ) {
                Text(
                    text = "Пропустить",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}