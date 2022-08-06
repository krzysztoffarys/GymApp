package com.crys.gymapp.feature_weight.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crys.gymapp.databinding.ActivityMainBinding
import com.crys.gymapp.feature_weight.presentation.weight.WeightActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnHello.setOnClickListener {
            startActivity(Intent(this, WeightActivity::class.java))
        }
    }
}