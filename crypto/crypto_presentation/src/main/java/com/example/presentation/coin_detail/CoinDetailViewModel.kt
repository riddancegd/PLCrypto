package com.example.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Constants
import com.example.core.Resource
import com.example.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 *
 *  SavedStateHandle
 *
 *  Used to restore our app from process death.
 *  In the event of process death, the savedstatehandle will save
 *  the data we tell it to. And when we re launch the app, if we
 *  were in the screen where the SSH was used, it will restore the info
 *
 */

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(CoinDetailState())
        private set

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {

        viewModelScope.launch {

            getCoinUseCase(coinId).onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state = CoinDetailState(coin = result.data)
                    }
                    is Resource.Error -> {
                        state = CoinDetailState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }
                    is Resource.Loading -> {
                        state = CoinDetailState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }

    }
}