package com.myprojects.cryptocurrencyapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.cryptocurrencyapp.common.Constants
import com.myprojects.cryptocurrencyapp.common.Resource
import com.myprojects.cryptocurrencyapp.domain.use_case.get_coin.GetCoinDetailUseCase
import com.myprojects.cryptocurrencyapp.domain.use_case.get_coins.GetCoinUseCase
import com.myprojects.cryptocurrencyapp.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val getCoinDetailUseCase: GetCoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_PARAM)?.let { coinId ->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId).onEach { resource ->
            when(resource) {
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = resource.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(errorMessage = resource.message ?: "An error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}