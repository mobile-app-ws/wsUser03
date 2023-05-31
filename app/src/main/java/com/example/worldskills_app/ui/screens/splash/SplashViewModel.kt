package com.example.worldskills_app.ui.screens.splash

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import com.example.worldskills_app.data.DataStore
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

data class SplashState(
    val isGoNextEventEffect: StateEvent = consumed,
    val isGoOnBoarEventEffect: StateEvent = consumed
)

class SplashViewModel(
    private val dataStore: DataStore
) : BaseViewModel<SplashState>() {
    override val initialState = SplashState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {
                    delay(3000)
                    dataStore.isShowOnBoardFlow.collectLatest { bool ->
                        if (!bool) {
                            dataStore.setOnBoardValue()
                        } else {
                            state = state.copy(
                                isGoNextEventEffect = triggered
                            )
                        }
                    }
                }
            }
        }
    }

    fun onBoardConsumed() {
        state = state.copy(
            isGoOnBoarEventEffect = consumed
        )
    }

    fun onNextConsumed() {
        state = state.copy(
            isGoNextEventEffect = consumed
        )
    }
}