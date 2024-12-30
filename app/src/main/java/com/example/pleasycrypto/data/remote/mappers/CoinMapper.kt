package com.example.pleasycrypto.data.remote.mappers

import com.example.pleasycrypto.data.remote.dto.CoinDetailDto
import com.example.pleasycrypto.data.remote.dto.CoinDto
import com.example.pleasycrypto.domain.model.Coin
import com.example.pleasycrypto.domain.model.CoinDetail


fun CoinDto.toCoin(): Coin {

    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )

}

fun CoinDetailDto.toCoinDetail() : CoinDetail {

    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map{ it.name },
        team = team,
    )

}