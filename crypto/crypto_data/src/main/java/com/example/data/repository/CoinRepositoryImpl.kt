package com.example.data.repository

import com.example.core.Resource
import com.example.data.remote.CoinPaprikaApi
import com.example.data.remote.mappers.toCoin
import com.example.data.remote.mappers.toCoinDetail
import com.example.domain.model.Coin
import com.example.domain.model.CoinDetail
import com.example.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {



    override suspend fun getCoins(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading)
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch(e: HttpException){

            emit( Resource.Error(e.localizedMessage ?: "An unexpected error ocurred") )

        }catch (e: IOException){

            emit( Resource.Error("Could not reach server. Check your internet connection") )

        }

    }

    override suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> = flow {

        try {

            emit(Resource.Loading)
            val coin = api.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An unexpected error ocurred"))

        } catch (e: IOException) {

            emit(Resource.Error("Could not reach server, check your internet connection"))

        }
    }


}