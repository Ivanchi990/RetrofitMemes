package com.example.apimemes.actividadesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityEliminarMemeIdBinding
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EliminarMemeId : AppCompatActivity()
{
    lateinit var binding: ActivityEliminarMemeIdBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarMemeIdBinding.inflate(layoutInflater)

        binding.btnEliminar.setOnClickListener{
            eliminarMeme()
        }

        setContentView(binding.root)
    }

    private fun eliminarMeme()
    {
        if(!binding.etIdEliminar.text.isEmpty())
        {
            MemeRetrofitInstance.api.deleteMeme("/meme/borrar?id=${binding.etIdEliminar.text}")
        }
        else
        {
            Toast.makeText(this, "Vaya, parece que no hay nada que eliminar", Toast.LENGTH_SHORT).show()
        }
    }
}