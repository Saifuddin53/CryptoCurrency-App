package com.myprojects.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.myprojects.cryptocurrencyapp.domain.model.Coin

@Composable
fun CoinListScreen(
) {
    
}

@Composable
fun CoinListItem(coin: Coin) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), 
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
        ) {
            Text(text = coin.id)
            Text(text = coin.name)
        }
        if(coin.isActive) {
            Text(text = "active")
        }else {
            Text(text = "unactive")
        }
    }
}

@Preview
@Composable
fun CoinListItemPreview() {
    CoinListItem(coin = Coin("1", "Ethereum", 3, "sy", true))
}