package com.myprojects.cryptocurrencyapp.domain.use_case.get_coins

import com.myprojects.cryptocurrencyapp.common.Resource
import com.myprojects.cryptocurrencyapp.data.remote.dto.toCoin
import com.myprojects.cryptocurrencyapp.domain.model.Coin
import com.myprojects.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoin().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Http Exception error"))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception error"))
        }
    }
}