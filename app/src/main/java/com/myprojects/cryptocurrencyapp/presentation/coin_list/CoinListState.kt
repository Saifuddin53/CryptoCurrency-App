package com.myprojects.cryptocurrencyapp.presentation.coin_list

import com.myprojects.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val errorMessage: String = ""
)
