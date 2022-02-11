package com.example.daggercomponenttest.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggercomponenttest.main.dependency.TextGenerator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainViewModel(private val textGenerator: TextGenerator) : ViewModel() {

    val text: Flow<String> = flow { emit(textGenerator.generateText()) }

    class Factory @Inject constructor(
        private val textGenerator: TextGenerator
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == MainViewModel::class.java)
            return MainViewModel(textGenerator) as T
        }
    }
}