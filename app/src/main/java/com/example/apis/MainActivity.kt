package com.example.apis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apis.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var adapter: PlanetasAdapter
    private val viewModel:MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
        viewModel.getPlanet()
    }

    private fun initObserver() {
        viewModel.responseText.observe(this) { responseText ->
            recicleview(responseText)
        }
    }

    private fun recicleview(planetas: PlanetResponse){
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = PlanetasAdapter(planetas.results)
        binding.recyclerview.adapter = adapter

    }


}






