package com.example.daggercomponenttest.di

import com.example.daggercomponenttest.main.dependency.TextGenerator
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideTextGenerator(): TextGenerator = TextGenerator()
}