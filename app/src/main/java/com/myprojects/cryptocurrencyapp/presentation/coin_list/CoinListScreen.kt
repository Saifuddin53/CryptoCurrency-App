package com.myprojects.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.myprojects.cryptocurrencyapp.domain.model.Coin
import com.myprojects.cryptocurrencyapp.presentation.Screen
import com.myprojects.cryptocurrencyapp.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            Modifier.fillMaxSize()
        ) {
            items(state.coinList) { coin ->
                CoinListItem(coin = coin) {
                    navController.navigate(Screen.CoinDetailScreen.route + "/${it.id}")
                }
            }
        }

        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        if(state.errorMessage.isNotBlank()) {
            Text(
                text = "Error",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
                )
        }
    }
}
