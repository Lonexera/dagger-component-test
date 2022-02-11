package com.example.daggercomponenttest.feature

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.daggercomponenttest.di.feature.DaggerFeatureComponent
import com.example.daggercomponenttest.di.feature.FeatureComponent
import com.example.daggercomponenttest.di.feature.featureDependenciesProvider

class FeatureComponentViewModel(
    application: Application
    ) : AndroidViewModel(application) {

    val featureComponent: FeatureComponent by lazy {
        DaggerFeatureComponent.builder()
            .dependencies(application.featureDependenciesProvider.dependencies)
            .build()
    }
}