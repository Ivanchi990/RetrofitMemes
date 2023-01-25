package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apimemes.databinding.ActivityCrearMemeBinding
import com.example.apimemes.memapi.Meme
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityCrearMeme : AppCompatActivity()
{
    private lateinit var binding: ActivityCrearMemeBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMemeBinding.inflate(layoutInflater)

        binding.btnCrearMeme.setOnClickListener{
            crearMeme()
        }

        setContentView(binding.root)
    }


    fun crearMeme()
    {
        if(datosRellenos())
        {
            MemeRetrofitInstance.api.postMeme(
                "/meme", Meme(
                    binding.textoNombre.text.toString(),
                    binding.textoSup.text.toString(),
                    binding.textoInf.text.toString(),
                    binding.textoUrl.text.toString(),
                    binding.textoTag.text.toString()
                )
            )
                .enqueue(object : Callback<MemeResponse> {
                    override fun onResponse(
                        call: Call<MemeResponse>,
                        response: Response<MemeResponse>
                    ) {
                        if (response.body() != null) {
                            intent = Intent(applicationContext, ActivityMostrarMemeId::class.java).apply {
                                putExtra("id", response.body()!!.idMeme.toString())
                            }

                            startActivity(intent)
                        }
                            else
                        {
                            return
                        }
                    }

                    override fun onFailure(call: Call<MemeResponse>, t: Throwable)
                    {
                        Log.d("TAG", t.message.toString())
                    }
                })
        }
        else
        {
            Toast.makeText(this, "Parece que faltan campos por rellenar", Toast.LENGTH_SHORT).show()
        }
    }

    fun datosRellenos(): Boolean
    {
        return  !(binding.textoNombre.text.equals("") &&
                binding.textoSup.text.equals("") &&
                binding.textoInf.text.equals("") &&
                binding.textoUrl.text.equals("") &&
                binding.textoTag.text.equals(""))
    }
}