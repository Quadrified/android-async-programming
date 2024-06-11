package com.quadrified.androidasyncprogramming.ahmed.retrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quadrified.androidasyncprogramming.ahmed.retrofit.data.ApiResult
import com.quadrified.androidasyncprogramming.ahmed.retrofit.data.ProductsRepository
import com.quadrified.androidasyncprogramming.ahmed.retrofit.data.model.Products
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private var _products = MutableStateFlow<List<Products>>(emptyList())
    val products = _products.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            productsRepository.getProductsList().collectLatest { result ->
                when (result) {
                    is ApiResult.Error -> {
                        _showErrorToastChannel.send((true))
                    }

                    is ApiResult.Success -> {
                        result.data?.let {
                            _products.update { it }
                        }
                    }
                }
            }
        }
    }

}