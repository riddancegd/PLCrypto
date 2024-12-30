package com.example.pleasycrypto.domain.use_case.get_coin

import com.example.pleasycrypto.core.Resource
import com.example.pleasycrypto.data.remote.mappers.toCoinDetail
import com.example.pleasycrypto.domain.model.CoinDetail
import com.example.pleasycrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    /**
     * When you use operator and name your function invoke you override the behavior that your class has
     * when an object of it is written with parenthesis. Like "getCoinUseCase()"
      */

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {

        try {

            emit(Resource.Loading)
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        }catch (e: HttpException){

            emit(Resource.Error(e.localizedMessage ?: "An unexpected error ocurred"))

        } catch (e: IOException){

            emit(Resource.Error("Could not reach server, check your internet connection"))

        }

    }


}