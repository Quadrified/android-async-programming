package com.quadrified.androidasyncprogramming.ahmedretrofit.data

import com.quadrified.androidasyncprogramming.ahmedretrofit.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<ApiResult<List<Product>>>
}