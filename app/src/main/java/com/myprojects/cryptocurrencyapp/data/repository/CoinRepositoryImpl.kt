package com.myprojects.cryptocurrencyapp.data.repository

import com.myprojects.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.myprojects.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.myprojects.cryptocurrencyapp.data.remote.dto.CoinDto
import com.myprojects.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}