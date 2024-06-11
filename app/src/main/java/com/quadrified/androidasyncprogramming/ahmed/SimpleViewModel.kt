package com.quadrified.androidasyncprogramming.ahmed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SimpleViewModel : ViewModel() {
    /**
     * StateFlow
     */
    // mutable, can be updated only in viewModel, not shared publicly
    private val _textSate = MutableStateFlow("")

    // immutable, used to observe value in UI, shared publicly
    val textState = _textSate.asStateFlow()

    /**
     * SharedFlow
     */

    private val _sharedFlow = MutableSharedFlow<Boolean>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    /**
     * Channel
     */
    private val _channel = Channel<Boolean>()
    val channelFlow = _channel.receiveAsFlow()

    init {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            delay(2000L)
//            _sharedFlow.emit(true)

            // channel events
            _channel.send(true)
        }
    }

    fun changeText(text: String) {
        // way 1
//        _textSate.value = text

        // way 2
        _textSate.update { text }
    }

}