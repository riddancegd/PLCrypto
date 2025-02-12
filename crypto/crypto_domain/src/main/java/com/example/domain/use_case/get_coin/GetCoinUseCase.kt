package com.example.domain.use_case.get_coin

import com.example.core.Resource
import com.example.domain.model.CoinDetail
import com.example.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    /**
     * When you use operator and name your function invoke you override the behavior that your class has
     * when an object of it is written with parenthesis. Like "getCoinUseCase()"
     */

    suspend operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {

        return coinRepository.getCoinById(coinId)

    }


}