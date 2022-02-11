package com.example.daggercomponenttest.di.feature

import android.app.Application
import android.content.Context
import com.example.daggercomponenttest.feature.FeatureActivity
import com.example.daggercomponenttest.main.dependency.TextGenerator
import dagger.Component
import javax.inject.Scope

@Scope
annotation class FeatureScope

@Component(
    modules = [FeatureModule::class],
    dependencies = [FeatureComponent.Dependencies::class]
)
@FeatureScope
interface FeatureComponent {
    fun inject(featureActivity: FeatureActivity)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: Dependencies): Builder
        fun build(): FeatureComponent
    }

    interface Dependencies {
        val textGenerator: TextGenerator
    }
}

interface FeatureDependenciesProvider {
    val dependencies: FeatureComponent.Dependencies
}

val Context.featureDependenciesProvider: FeatureDependenciesProvider
get() = when (this) {
    is FeatureDependenciesProvider -> this
    is Application -> error("Application must implement FeatureDependenciesProvider")
    else -> applicationContext.featureDependenciesProvider
}
