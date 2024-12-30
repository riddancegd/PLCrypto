package com.example.pleasycrypto.data.repository

import com.example.pleasycrypto.data.remote.CoinPaprikaApi
import com.example.pleasycrypto.data.remote.dto.CoinDetailDto
import com.example.pleasycrypto.data.remote.dto.CoinDto
import com.example.pleasycrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }


}