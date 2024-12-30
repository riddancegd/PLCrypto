package com.example.pleasycrypto.domain.repository

import com.example.pleasycrypto.data.remote.dto.CoinDetailDto
import com.example.pleasycrypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto

}