package com.example.domain.repository

import com.example.core.Resource
import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins() : Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId : String) : Flow<Resource<CoinDetail>>

}