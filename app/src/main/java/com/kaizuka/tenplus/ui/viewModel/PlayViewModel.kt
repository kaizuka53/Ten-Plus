package com.kaizuka.tenplus.ui.viewModel

import android.media.tv.TableRequest
import androidx.lifecycle.ViewModel
import com.kaizuka.tenplus.ui.playState.PlayScreenState
import com.kaizuka.tenplus.util.CalculationChecker
import kotlinx.coroutines.flow.MutableStateFlow

class PlayViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(PlayScreenState(useNumber = listOf()))
    val uiState = _uiState
    private val targetNumber = TARGET_NUMBER

    private fun currentState() = _uiState.value
    private fun updateState(state: PlayScreenState) {
        _uiState.value = state
    }

    fun setUseNumber(useNumber: List<Int>) {
        updateState(currentState().copy(useNumber = useNumber))
    }

    fun checkCollectAnswer(answer: List<Char>): Boolean {
        //val ans = CalculationChecker().check(answer, targetNumber)
        return true
    }

    companion object {
        private const val TAG = "PlayViewModel"
        private const val TARGET_NUMBER = 10
    }



}