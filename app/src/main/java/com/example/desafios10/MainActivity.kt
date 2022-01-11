package com.example.desafios10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafios10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.dataLiveData.observe(this, Observer {
            binding.tvTextoGuardado.text = getString(R.string.textA1, binding.etTexto.text.toString())
        })


        binding.btGuardarInfo.setOnClickListener {
            viewModel.setData(binding.etTexto.text.toString())
        }

        binding.btLanzarAct.setOnClickListener {
            startVistaActivity()
        }


    }

    private fun startVistaActivity() {
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra(Activity2.KEY ,viewModel.dataLiveData.value)
        startActivity(intent)
    }

    override fun onResume() {
        binding.etTexto.text.clear()
        super.onResume()
    }

}