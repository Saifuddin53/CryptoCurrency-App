package com.myprojects.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myprojects.cryptocurrencyapp.presentation.coin_details.CoinDetailScreen
import com.myprojects.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import com.myprojects.cryptocurrencyapp.presentation.ui.theme.CryptoCurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoCurrencyAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CoinListScreen.route
                ) {
                    composable(
                        route = Screen.CoinListScreen.route
                    ) {
                        CoinListScreen(navController)
                    }
                    composable(
                        route = Screen.CoinDetailScreen.route + "/{coinId}"
                    ) {
                        CoinDetailScreen()
                    }
                }
            }
        }  
    }
}
