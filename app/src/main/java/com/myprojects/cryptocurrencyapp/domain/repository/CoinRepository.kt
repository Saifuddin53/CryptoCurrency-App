package com.myprojects.cryptocurrencyapp.domain.repository

import com.myprojects.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.myprojects.cryptocurrencyapp.data.remote.dto.CoinDto
import com.myprojects.cryptocurrencyapp.domain.model.Coin

interface CoinRepository {

    suspend fun getCoin(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}