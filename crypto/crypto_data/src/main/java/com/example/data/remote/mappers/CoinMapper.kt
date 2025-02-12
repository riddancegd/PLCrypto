package com.example.data.remote.mappers

import com.example.data.remote.dto.CoinDetailDto
import com.example.data.remote.dto.CoinDto
import com.example.data.remote.dto.TeamMemberDto
import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail
import com.example.domain.model.TeamMember

fun CoinDto.toCoin(): Coin {

    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )

}

fun CoinDetailDto.toCoinDetail(): CoinDetail {

    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team.map { it.toTeamMember() },
    )

}

fun TeamMemberDto.toTeamMember(): TeamMember {

    return TeamMember(
        id = id, name = name, position = position
    )

}