package com.example.daggercomponenttest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.daggercomponenttest.DaggerAppTest
import com.example.daggercomponenttest.R
import com.example.daggercomponenttest.feature.FeatureActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var mainViewModelFactory: MainViewModel.Factory

    private val viewModel: MainViewModel by viewModels { mainViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as DaggerAppTest).appComponent.inject(this)

        val textView = findViewById<TextView>(R.id.tv_main)
        val btnNext = findViewById<Button>(R.id.btn_feature)

        btnNext.setOnClickListener {
            val intent = Intent(this, FeatureActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.text.collect {
                textView.text = it
            }
        }
    }
}