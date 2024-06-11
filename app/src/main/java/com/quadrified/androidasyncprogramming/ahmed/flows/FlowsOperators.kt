package com.quadrified.androidasyncprogramming.ahmed.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowsOperators {

    // for filter and map
    private var counter = 1
    fun flowTimer(): Flow<String> = flow {
        emit("this is $counter")
        delay(1000L)
        counter++

        emit("that is $counter")
        delay(1000L)
        counter++

        emit("this is $counter")
        delay(1000L)
        counter++

        emit("that is $counter")
        delay(1000L)
        counter++
    }

    // for flatMapConcat and flatMapLatest
    fun flowRepeater(): Flow<Int> = flow {
        repeat(5) {
            emit(it)
        }
    }


    // for collectLatest
    private var results = listOf("Kotlin", "Java", "Swift")

    fun searchListFlow(): Flow<String> = flow {
        emit(results[0])
        delay(500L)


        emit(results[1])
        delay(500L)


        emit(results[2])
        delay(500L)

    }

}

fun main() {
    runBlocking {
        // filter
//        flowTimer().filter {
//            it.contains("this")
//        }.collect {
//            Log.d(TAG, "filter $it")
//        }

        // map
//        flowTimer().map {
//            it + 2
//        }.collect {
//            Log.d(TAG, "map $it")
//        }

        // flatMapConcat
//        flowRepeater().flatMapConcat {
//            flow {
//                delay(1000L)
//                emit(it * 10)
//            }
//        }.collect {
//            Log.d(TAG, "counter: $it")
//        }

        // flatMapLatest
//        flowRepeater().flatMapLatest {
//            flow {
//                delay(1000L)
//                emit(it * 10)
//            }
//        }.collect {
//            Log.d(TAG, "counter: $it")
//        }

        // collectLatest
//        searchListFlow().onEach { result ->
//            Log.d(TAG, "we got $result")
//        }.collectLatest {
//            delay(1000L) // imitate loading
//            Log.d(TAG, "result is $it")
//        }
    }
}
