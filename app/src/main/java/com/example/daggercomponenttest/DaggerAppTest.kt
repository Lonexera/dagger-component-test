package com.example.daggercomponenttest

import android.app.Application
import com.example.daggercomponenttest.di.AppComponent
import com.example.daggercomponenttest.di.DaggerAppComponent

class DaggerAppTest : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }
}