package com.quadrified.androidasyncprogramming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.quadrified.androidasyncprogramming.ui.theme.AndroidBasicsCheesyCodeTheme
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : ComponentActivity() {

    val TAG = "MainActivityCoroutine"
    private var finalResponse = "Loading..."

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsCheesyCodeTheme {
//                CoroutineExample(finalResponse)
            }
        }
    }
}