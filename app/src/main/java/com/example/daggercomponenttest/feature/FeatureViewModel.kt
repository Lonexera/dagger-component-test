package com.example.daggercomponenttest.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggercomponenttest.feature.dependency.FeatureTextGenerator
import com.example.daggercomponenttest.main.dependency.TextGenerator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeatureViewModel(
    private val textGenerator: TextGenerator,
    private val featureTextGenerator: FeatureTextGenerator
) : ViewModel() {

    val text: Flow<String> = flow {
        emit(
        textGenerator.generateText() + featureTextGenerator.generateFeatureText()
        )
    }

    class Factory @Inject constructor(
        private val textGenerator: TextGenerator,
        private val featureTextGenerator: FeatureTextGenerator
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == FeatureViewModel::class.java)
            return FeatureViewModel(textGenerator, featureTextGenerator) as T
        }
    }

}