package com.quadrified.androidasyncprogramming.ahmedretrofit.data

import com.quadrified.androidasyncprogramming.ahmedretrofit.data.model.Products
import retrofit2.http.GET

interface Api {

    @GET("products/{type}")
    suspend fun getProductsList(): Products

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}


/**
 * Setting up API with various params
 */
//@GET("products/{type}")
//suspend fun getProductsList(
//    @Path("type") type: String, // -> "https://dummyjson.com/products/?..."
//    @Query("api_key") apiKey: String, // -> "https://dummyjson.com?api_key=123&page=1"
//    @Query("page") page: Int, // -> "https://dummyjson.com?page=1&api_key=123"
//): Products
