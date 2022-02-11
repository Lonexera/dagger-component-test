package com.example.daggercomponenttest.di.feature

import com.example.daggercomponenttest.feature.dependency.FeatureTextGenerator
import dagger.Module
import dagger.Provides

@Module
class FeatureModule {

    @FeatureScope
    @Provides
    fun provideFeatureTextGenerator(): FeatureTextGenerator =
        FeatureTextGenerator()
}