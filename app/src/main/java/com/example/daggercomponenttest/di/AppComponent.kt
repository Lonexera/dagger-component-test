package com.example.daggercomponenttest.di

import android.app.Application
import com.example.daggercomponenttest.di.feature.FeatureComponent
import com.example.daggercomponenttest.main.MainActivity
import com.example.daggercomponenttest.main.dependency.TextGenerator
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent : FeatureComponent.Dependencies {
    fun inject(mainActivity: MainActivity)

    override val textGenerator: TextGenerator

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}

@Scope
annotation class AppScope