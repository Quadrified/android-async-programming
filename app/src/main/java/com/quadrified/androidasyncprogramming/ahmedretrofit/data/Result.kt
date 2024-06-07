package com.quadrified.androidasyncprogramming.ahmedretrofit.data

// sealed class -> class that can only be inherited from within the same file where it is declared
// restricted inheritance

sealed class ApiResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : ApiResult<T>(data)
    class Error<T>(data: T? = null, message: String) : ApiResult<T>(data, message)
}


/**
 * Example
 */
//sealed class NetworkResponse {
//    data class Success(val data: String) : NetworkResponse()
//    data class Error(val errorMessage: String) : NetworkResponse()
//    object Loading : NetworkResponse()
//}
//
//fun handleResponse(response: NetworkResponse) {
//    when (response) {
//        is NetworkResponse.Success -> {
//            println("Data received: ${response.data}")
//        }
//        is NetworkResponse.Error -> {
//            println("Error occurred: ${response.errorMessage}")
//        }
//        NetworkResponse.Loading -> {
//            println("Loading...")
//        }
//    }
//}
//
//fun main() {
//    val successResponse = NetworkResponse.Success("Some data")
//    val errorResponse = NetworkResponse.Error("An error occurred")
//    val loadingResponse = NetworkResponse.Loading
//
//    handleResponse(successResponse) // Output: Data received: Some data
//    handleResponse(errorResponse)   // Output: Error occurred: An error occurred
//    handleResponse(loadingResponse) // Output: Loading...
//}
