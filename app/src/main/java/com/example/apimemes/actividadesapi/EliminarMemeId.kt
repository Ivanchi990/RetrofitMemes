package com.example.apimemes.actividadesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apimemes.databinding.ActivityEliminarMemeIdBinding

class EliminarMemeId : AppCompatActivity()
{
    lateinit var binding: ActivityEliminarMemeIdBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarMemeIdBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}