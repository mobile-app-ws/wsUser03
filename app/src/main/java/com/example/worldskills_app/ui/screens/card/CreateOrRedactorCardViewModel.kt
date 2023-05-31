package com.example.worldskills_app.ui.screens.card

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import com.example.worldskills_app.models.User
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.http.HttpStatusCode
import io.ktor.http.parametersOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

data class CreateOrRedactorCardState(
    val userCard: User = User(),
    val error: String = "",
    val errorEvent: StateEvent = consumed,
    val saveEvent: StateEvent = consumed
)

class CreateOrRedactorCardViewModel(
    private val httpClient: HttpClient
) : BaseViewModel<CreateOrRedactorCardState>() {
    override val initialState = CreateOrRedactorCardState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {

                }
            }
        }
    }

    fun onSaveUserDate(){
        viewModelScope.launch {
            saveUserDate()
        }
    }

    private suspend fun saveUserDate() {
        httpClient.post(
            urlString = "api/createProfile"
        ) {
            parametersOf(
                state.userCard.getUserForParameters()
            )
        }.let {
            if (it.status != HttpStatusCode.OK) {
                state = state.copy(
                    error = it.status.description,
                    errorEvent = triggered
                )
            }else{
                state = state.copy(
                    saveEvent = triggered
                )
            }
        }
    }

    fun onUpdateUserDate(){
        viewModelScope.launch {
            updateUserDate()
        }
    }

    private suspend fun updateUserDate() {
        httpClient.put(
            urlString = "api/updateProfile"
        ) {
            parametersOf(
                state.userCard.getUserForParameters()
            )
        }.let {
            if (it.status != HttpStatusCode.OK) {
                state = state.copy(
                    error = it.status.description,
                    errorEvent = triggered
                )
            }else{
                state = state.copy(
                    saveEvent = triggered
                )
            }
        }
    }

    fun onConsumedErrorEvent() {
        state = state.copy(
            error = "",
            errorEvent = consumed
        )
    }

    fun onConsumedSaveEvent(){
        state = state.copy(
            saveEvent = consumed
        )
    }
}