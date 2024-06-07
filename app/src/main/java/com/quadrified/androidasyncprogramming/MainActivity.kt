package com.quadrified.androidasyncprogramming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quadrified.androidasyncprogramming.ahmedretrofit.data.ProductsRepositoryImpl
import com.quadrified.androidasyncprogramming.ahmedretrofit.presentation.ProductViewModel
import com.quadrified.androidasyncprogramming.ui.theme.AndroidBasicsCheesyCodeTheme
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : ComponentActivity() {

    val TAG = "MainActivityCoroutine"
    private var finalResponse = "Loading..."

    private val viewModel by viewModels<ProductViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProductViewModel(ProductsRepositoryImpl(RetrofitInstance.api))
            }
        }
    })

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





