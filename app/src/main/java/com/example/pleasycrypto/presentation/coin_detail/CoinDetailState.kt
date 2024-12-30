package com.example.pleasycrypto.presentation.coin_detail

import com.example.pleasycrypto.domain.model.CoinDetail

data class CoinDetailState(

    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""

)