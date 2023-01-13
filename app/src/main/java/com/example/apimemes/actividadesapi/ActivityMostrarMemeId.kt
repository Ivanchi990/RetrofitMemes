package com.example.apimemes.actividadesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apimemes.databinding.ActivityMostrarMemeIdBinding
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import retrofit2.*

class ActivityMostrarMemeId : AppCompatActivity()
{
    lateinit var binding: ActivityMostrarMemeIdBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarMemeIdBinding.inflate(layoutInflater)

        binding.buscarId.setOnClickListener {
            mostrarMeme()
        }

        setContentView(binding.root)
    }

    fun mostrarMeme()
    {
        var id = binding.textId.text

        if(id == null || id.equals(""))
        {
            Toast.makeText(this, "Necesito que escribas el id para mostrartelo", Toast.LENGTH_SHORT).show()
        }
        else
        {
            MemeRetrofitInstance.api.getMeme("/meme?id=")
                .enqueue(object : Callback<MemeResponse> {
                    override fun onResponse(
                        call: Call<MemeResponse>,
                        response: Response<MemeResponse>
                    ) {
                        if (response.body() != null) {
                            //binding.tvSetup.text = response.body()?.setup


                        } else {
                            return
                        }
                    }

                    override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                        Log.d("TAG", t.message.toString())
                    }
                })
        }
    }
}