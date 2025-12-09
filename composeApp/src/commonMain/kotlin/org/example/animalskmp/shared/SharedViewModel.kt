package org.example.animalskmp.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class SharedViewModel : ViewModel() {

    private val _state = MutableStateFlow("Click me")
    val state = _state.asStateFlow()

    fun updateMessage() {
        viewModelScope.launch {
            _state.value = "Loading in KMP"
            delay(1.seconds)
            _state.value = "Random from KMP: ${Random.Default.nextInt()}"
        }
    }
}