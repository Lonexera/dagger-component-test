package com.example.daggercomponenttest.feature

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.daggercomponenttest.R
import javax.inject.Inject

class FeatureActivity : AppCompatActivity() {

    @Inject
    internal lateinit var featureViewModelFactory: FeatureViewModel.Factory

    private val componentViewModel: FeatureComponentViewModel by viewModels()
    private val featureViewModel: FeatureViewModel by viewModels {
        featureViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
        componentViewModel.featureComponent.inject(this)

        val textView = findViewById<TextView>(R.id.tv_feature)

        lifecycleScope.launchWhenCreated {
            featureViewModel.text.collect {
                textView.text = it
            }
        }
    }
}