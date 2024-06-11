package com.quadrified.androidasyncprogramming.ahmed.retrofit.data

import com.quadrified.androidasyncprogramming.ahmed.retrofit.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<ApiResult<List<Product>>>
}