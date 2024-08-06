package com.myprojects.cryptocurrencyapp.domain.model

data class Coin(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val isActive: Boolean
)