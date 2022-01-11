package com.example.desafios10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafios10.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    companion object{
        const val KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.text = getString(R.string.textA2, intent.getStringExtra(KEY))
    }
}