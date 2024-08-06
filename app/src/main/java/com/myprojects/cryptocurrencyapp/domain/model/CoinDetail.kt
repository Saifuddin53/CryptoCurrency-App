package com.myprojects.cryptocurrencyapp.domain.model

import com.myprojects.cryptocurrencyapp.data.remote.dto.Tag
import com.myprojects.cryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val rank: Int,
    val symbol: String,
    val isActive: Boolean,
    val tags: List<Tag>,
    val team: List<TeamMember>,
)
