package com.quadrified.androidasyncprogramming.ahmed.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Flows {

    /**
     * Flows example 1
     */
    fun getDataFlow(): Flow<String> {
        return flow {
            emit("Start loading...")
            delay(1000L)

            emit("Get data...")
            delay(2000L)

            emit("Start filtering...")
            delay(500L)

            emit("Data is ready...")
            delay(200L)

            emit("Stop loading...")
        }
    }

    /**
     * Flows Example 2 - Countdown Timer
     */
    var startTime = 10
    fun countdownTimer(): Flow<Int> = flow {
        while (startTime >= 0) {
            emit(startTime)
            delay(1000L)
            startTime--
        }
    }
}

/**
 * In MainActivity
 */
//
//runBlocking {
//    getDataFlow().collect { data ->
//        Log.d(FLOW_TAG, "received $data")
//    }
//
//    countdownTimer().collect { time ->
//        Log.d(FLOW_TAG, "timer: $time")
//    }
//}