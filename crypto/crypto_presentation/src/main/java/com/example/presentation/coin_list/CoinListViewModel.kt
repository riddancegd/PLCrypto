package com.example.presentation.coin_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.domain.use_case.get_coins.GetCoinsUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {


    var state by mutableStateOf(CoinListState())
        private set

    init {
        getCoins()
    }

    private fun getCoins() {

        viewModelScope.launch {

            getCoinsUseCase().onEach { result ->

                when (result) {
                    is Resource.Success -> {

                        state = CoinListState(coins = result.data ?: emptyList())

                    }

                    is Resource.Error -> {

                        state =
                            CoinListState(error = result.message ?: "An unexpected error occurred")

                    }

                    is Resource.Loading -> {

                        state = CoinListState(isLoading = true)

                    }
                }

            }.launchIn(viewModelScope)
        }

    }


}