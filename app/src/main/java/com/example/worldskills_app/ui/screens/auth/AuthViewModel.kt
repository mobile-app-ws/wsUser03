package com.example.worldskills_app.ui.screens.auth

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

data class AuthState(
    val email: String = "",
    val error: String = "",
    val errorEvent: StateEvent = consumed,
    val onGoNext: StateEvent = consumed
)

class AuthViewModel(
    private val httpClient: HttpClient
) : BaseViewModel<AuthState>() {

    override val initialState = AuthState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {

                }
            }
        }
    }

    fun setEmail(
        email: String
    ) {
        state = state.copy(
            email = email
        )
    }

    fun onSendSmsCode() {
        viewModelScope.launch {
            sendSmsCode()
        }
    }

    private suspend fun sendSmsCode() {
        if (checkIsEmail()){
            httpClient.post(
                urlString = "api/sendCode"
            ) {
                header("email", state.email)
            }.let {
                if (it.status != HttpStatusCode.OK) {
                    state = state.copy(
                        error = it.status.description,
                        errorEvent = triggered
                    )
                }else{
                    state.copy(
                        onGoNext = triggered
                    )
                }
            }
        }else{
            state = state.copy(
                errorEvent = triggered,
                error = "Введите корректный email адрес"
            )
        }
    }

    private fun checkIsEmail(): Boolean =
        android.util.Patterns.EMAIL_ADDRESS.matcher(state.email).matches()

    fun onConsumedErrorEvent() {
        state = state.copy(
            error = "",
            errorEvent = consumed
        )
    }

    fun onConsumedGoNextEvent(){
        state = state.copy(
            onGoNext = triggered
        )
    }
}