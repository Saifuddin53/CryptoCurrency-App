package com.myprojects.cryptocurrencyapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.myprojects.cryptocurrencyapp.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        isActive = isActive
    )
}