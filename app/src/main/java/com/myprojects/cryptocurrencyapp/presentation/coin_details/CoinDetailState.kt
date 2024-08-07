package com.myprojects.cryptocurrencyapp.presentation.coin_details

import com.myprojects.cryptocurrencyapp.domain.model.Coin
import com.myprojects.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val errorMessage: String = ""
)
