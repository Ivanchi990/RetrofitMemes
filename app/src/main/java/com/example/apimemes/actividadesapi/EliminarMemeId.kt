package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.apimemes.MainActivity
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityEliminarMemeIdBinding
import com.example.apimemes.memapi.DeleteResponse
import com.example.apimemes.memapi.Meme
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.google.gson.annotations.SerializedName
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
        MemeRetrofitInstance.api.deleteMeme(
            "/meme/borrar?id={${binding.etIdEliminar.text}}")
            .enqueue(object : Callback<DeleteResponse> {

                override fun onResponse(
                    call: Call<DeleteResponse>,
                    response: Response<DeleteResponse>
                ) {
                    if(response.body() != null)
                    {
                        if(response.body()!!.deleted)
                        {
                            Toast.makeText(applicationContext, "El meme se ha eliminado correctamente", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "El meme se ha eliminado correctamente", Toast.LENGTH_SHORT).show()
                        }

                        startActivity(Intent(applicationContext, MainActivity::class.java))
                    }
                    else
                    {
                        return
                    }
                }

                override fun onFailure(call: Call<DeleteResponse>, t: Throwable)
                {
                    Log.d("TAG", t.message.toString())
                }
            })
    }
}