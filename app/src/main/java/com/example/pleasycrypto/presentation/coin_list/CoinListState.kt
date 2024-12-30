package com.example.pleasycrypto.presentation.coin_list

import com.example.pleasycrypto.domain.model.Coin

/**
 * Gotta give an initial value to each property in order to be able to instantiate an empty
 * state in the viewmodel section where you declare your states at the beginning.
 */
data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""

    )
