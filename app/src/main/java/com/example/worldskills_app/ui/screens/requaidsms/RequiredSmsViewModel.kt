package com.example.worldskills_app.ui.screens.requaidsms

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

data class RequiredSmsState(
    val code: String = ""
)

class RequiredSmsViewModel(

): BaseViewModel<RequiredSmsState>(){

    override val initialState = RequiredSmsState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {

                }
            }
        }
    }
}