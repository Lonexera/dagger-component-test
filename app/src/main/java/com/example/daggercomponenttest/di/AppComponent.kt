package com.example.daggercomponenttest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}

@Scope
annotation class AppScope