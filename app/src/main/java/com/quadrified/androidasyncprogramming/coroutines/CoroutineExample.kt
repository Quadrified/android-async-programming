package com.quadrified.androidasyncprogramming.coroutines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay

private const val TAG = "CoroutineExample"

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun CoroutineExample(finalResponse: String) {
    var counter by remember {
        mutableIntStateOf(0)
    }

    fun updateCounter() {
        counter++
    }

    fun longRunningTask() {
        for (i in 1..1000000000L) {

        }
    }
//
//    fun doAction() {
//        CoroutineScope(Dispatchers.Default).launch {
//            Log.d(TAG, "Executing in ${Thread.currentThread().name}")
//        }
//
//        GlobalScope.launch {
//            Log.d(TAG, "Executing in ${Thread.currentThread().name}")
//        }
//
//        MainScope().launch {
//            Log.d(TAG, "Executing in ${Thread.currentThread().name}")
//        }
//
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier, text = finalResponse, fontSize = 32.sp
        )
//        Button(modifier = Modifier.padding(vertical = 16.dp), onClick = { updateCounter() }) {
//            Text(text = "Update Counter")
//        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CoroutineExamplePreview() {
    CoroutineExample("Loading...")
}


/**
 * Scopes
 */
//            GlobalScope.launch(Dispatchers.IO) {
//                Log.d(TAG, "Starting coroutine in ${Thread.currentThread().name}")
//                val res = doNetworkCall();
//
//                // Switching context to main thread
//                withContext(Dispatchers.Main) {
//                    Log.d(TAG, "Setting text in ${Thread.currentThread().name}")
//                    finalResponse = res
//                }
//            }

/**
 * runBlocking
 */
//            Log.d(TAG, "Before runBlocking")
//            runBlocking {
//                // launch => runs async
//                launch(Dispatchers.IO) {
//                    delay(3000L)
//                    Log.d(TAG, "Finished IO Coroutine 1 in ${Thread.currentThread().name}")
//                }
//                launch(Dispatchers.IO) {
//                    delay(3000L)
//                    Log.d(TAG, "Finished IO Coroutine 2 in ${Thread.currentThread().name}")
//                }
//                Log.d(TAG, "Starting runBlocking")
//                delay(5000L)
//                Log.d(TAG, "End runBlocking")
//            }
//            Log.d(TAG, "After runBlocking")

/**
 * Jobs, join, cancel, withTimeout
 */
//        val job = GlobalScope.launch(Dispatchers.Default) {
//            Log.d(TAG, "Starting Coroutine")
//            repeat(5) {
//                Log.d(TAG, "Coroutine running")
//                delay(1000L)
//            }
//        }

//        runBlocking {
//            job.join() // -> suspend function to resume main thread after coroutine is done
//            Log.d(TAG, "Main Thread Continuing")
//        }

//        val job = GlobalScope.launch(Dispatchers.Default) {
//            Log.d(TAG, "Starting long running calculation")
//            withTimeout(3000L) {
//                withTimeout => cancels coroutine automatically after timeout
//                for (i in 30..40) {
//                    if (isActive) {
//                        isActive => checks if coroutine is active during heavy tasks in Main thread
//                        Log.d(TAG, "Result for i = $i is ${fibonnacci(i)}")
//                    }
//                }
//            }
//            Log.d(TAG, "Ending long running calculation")
//        }
//        runBlocking {
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG, "Cancelled job")
//        }


/**
 * Async/Await
 */
//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                val res1 = async { doNetworkCall() }
//                val res2 = async { doNetworkCall2() }
//                Log.d(TAG, "Response 1: ${res1.await()}")
//                Log.d(TAG, "Response 2: ${res2.await()}")
//            }
//            Log.d(TAG, "Response took: $time ms")
//        }


private suspend fun doNetworkCall(): String {
    delay(3000L)
    return "This is a call 1 response"
}

private suspend fun doNetworkCall2(): String {
    delay(3000L)
    return "This is a call 2 response"
}

private fun fibonnacci(n: Int): Int {
    if (n <= 1) {
        return n
    }
    return fibonnacci(n - 1) + fibonnacci(n - 2)
}