package com.myprojects.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.cryptocurrencyapp.common.Resource
import com.myprojects.cryptocurrencyapp.domain.use_case.get_coins.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    val getCoinUseCase: GetCoinUseCase
): ViewModel(){
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinUseCase().onEach { resource ->
            when(resource) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinListState(coinList = resource.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CoinListState(errorMessage = resource.message ?: "An error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}