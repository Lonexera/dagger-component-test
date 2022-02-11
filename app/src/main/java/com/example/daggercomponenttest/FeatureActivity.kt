package com.example.daggercomponenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.daggercomponenttest.di.feature.DaggerFeatureComponent
import com.example.daggercomponenttest.di.feature.FeatureComponent

class FeatureActivity : AppCompatActivity() {

    val featureComponent: FeatureComponent by lazy {
        DaggerFeatureComponent.builder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        val textView = findViewById<TextView>(R.id.tv_feature)
    }
}