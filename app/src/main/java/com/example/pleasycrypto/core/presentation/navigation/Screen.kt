package com.example.pleasycrypto.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object CoinListScreen : Screen

    @Serializable
    data class CoinDetailScreen(val coinId: String) : Screen

}