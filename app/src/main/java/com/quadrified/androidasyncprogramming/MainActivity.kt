package com.quadrified.androidasyncprogramming

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quadrified.androidasyncprogramming.ahmed.SimpleViewModel
import com.quadrified.androidasyncprogramming.ui.theme.AndroidBasicsCheesyCodeTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : ComponentActivity() {

    private val TAG = "MainActivityFlows"
    private var finalResponse = "Loading..."

    // viewModel instance outside compose
    private val simpleViewModel1: SimpleViewModel by viewModels()

    @OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsCheesyCodeTheme {
//                CoroutineExample(finalResponse)

                /**
                 * StateFlow Example
                 */
                // viewModel instance inside compose
                val simpleViewModel = viewModel<SimpleViewModel>()

                // collecting/observing state from viewModel
                val textState = simpleViewModel.textState.collectAsState()

                val context = LocalContext.current

                LaunchedEffect(key1 = true) {
//                    simpleViewModel.sharedFlow.collect { show ->
//                        if (show) {
//                            Toast.makeText(context, "Shared Flow Toast", Toast.LENGTH_SHORT).show()
//                        }
//                    }
                    simpleViewModel.channelFlow.collect { show ->
                        if (show) {
                            Toast.makeText(context, "Shared Flow Toast", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = textState.value)
                    OutlinedTextField(value = textState.value, onValueChange = {
                        simpleViewModel.changeText(it)
                    })
                }
            }
        }
    }
}
