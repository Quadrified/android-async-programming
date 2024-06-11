package com.quadrified.androidasyncprogramming.ahmed.retrofit.data

import com.quadrified.androidasyncprogramming.ahmed.retrofit.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class ProductsRepositoryImpl(
    private val api: Api
) : ProductsRepository {

    override suspend fun getProductsList(): Flow<ApiResult<List<Product>>> {
        return flow {
            val productsFromApi = try {
                api.getProductsList()

            } catch (e: IOException) {
                e.printStackTrace()
                emit(ApiResult.Error(message = "Error loading products"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(ApiResult.Error(message = "Error loading products"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResult.Error(message = "Error loading products"))
                return@flow
            }

            emit(ApiResult.Success(productsFromApi.products))
        }

    }

}
