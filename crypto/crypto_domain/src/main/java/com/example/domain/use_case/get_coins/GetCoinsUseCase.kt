package com.example.domain.use_case.get_coins


import com.example.core.Resource
import com.example.domain.model.Coin
import com.example.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoins()
    }

}