package com.example.daggercomponenttest

import android.app.Application
import com.example.daggercomponenttest.di.AppComponent
import com.example.daggercomponenttest.di.DaggerAppComponent
import com.example.daggercomponenttest.di.feature.FeatureComponent
import com.example.daggercomponenttest.di.feature.FeatureDependenciesProvider

class DaggerAppTest : Application(), FeatureDependenciesProvider {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
    override val dependencies: FeatureComponent.Dependencies = appComponent
}