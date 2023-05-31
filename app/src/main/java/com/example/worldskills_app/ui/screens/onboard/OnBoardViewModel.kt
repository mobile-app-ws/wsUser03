package com.example.worldskills_app.ui.screens.onboard

import androidx.lifecycle.viewModelScope
import com.example.worldskills_app.BaseViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

enum class Position(value: Int){
    first(1),
    two(2),
    three(3);
    companion object{
        val countObject = 3
    }
}

data class OnBoardState(
    val nowPosistion: Position = Position.first
)

class OnBoardViewModel(

) : BaseViewModel<OnBoardState>() {
    override val initialState = OnBoardState()

    init {
        viewModelScope.launch {
            supervisorScope {
                launch {

                }
            }
        }
    }


}