package com.myprojects.cryptocurrencyapp.domain.use_case.get_coin

import com.myprojects.cryptocurrencyapp.common.Resource
import com.myprojects.cryptocurrencyapp.data.remote.dto.toCoin
import com.myprojects.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.myprojects.cryptocurrencyapp.domain.model.Coin
import com.myprojects.cryptocurrencyapp.domain.model.CoinDetail
import com.myprojects.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coins))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Http Exception error"))
        }catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "IO Exception error"))
        }
    }
}