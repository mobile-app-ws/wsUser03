package com.example.worldskills_app.ui.screens.analyzes

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import com.example.worldskills_app.models.NewsModels
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

data class AnalyzesState(
    val news: List<NewsModels> = emptyList(),
    val isLoading: Boolean = true
)

class AnalyzesViewModel(
    private val httpClient: HttpClient
) : BaseViewModel<AnalyzesState>() {
    override val initialState = AnalyzesState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {
                    getNews()
                }
            }
        }
    }

    private suspend fun getNews() {
        state = state.copy(
            isLoading = true
        )
        httpClient.get("api/news").let {
            val body = it.body<List<NewsModels>?>()
            if (body != null) {
                state = state.copy(
                    news = body
                )
            }
        }
        state = state.copy(
            isLoading = false
        )
    }
}