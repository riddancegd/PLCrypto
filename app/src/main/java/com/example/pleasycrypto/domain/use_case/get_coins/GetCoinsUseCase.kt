package com.example.pleasycrypto.domain.use_case.get_coins

import com.example.pleasycrypto.core.Resource
import com.example.pleasycrypto.data.remote.mappers.toCoin
import com.example.pleasycrypto.domain.model.Coin
import com.example.pleasycrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading)
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch(e: HttpException){

                emit( Resource.Error(e.localizedMessage ?: "An unexpected error ocurred") )

        }catch (e: IOException){

            emit( Resource.Error("Could not reach server. Check your internet connection") )

        }

    }

}