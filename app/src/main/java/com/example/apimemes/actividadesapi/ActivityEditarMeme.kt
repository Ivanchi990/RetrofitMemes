package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityEditarMemeBinding
import com.example.apimemes.memapi.Meme
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.example.apimemes.memapi.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityEditarMeme : AppCompatActivity()
{
    private lateinit var binding: ActivityEditarMemeBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarMemeBinding.inflate(layoutInflater)

        binding.btnEditar.setOnClickListener{
            editarMeme()
        }

        setContentView(binding.root)
    }


    fun editarMeme()
    {
        if(comprobarDatos())
        {
            MemeRetrofitInstance.api.editMeme(
                "/meme", Meme(
                    binding.textoNombre2.text.toString(),
                    binding.textoSup2.text.toString(),
                    binding.textoInf2.text.toString(),
                    binding.textoUrl2.text.toString(),
                    binding.textoTag2.text.toString()
                )
            )
                .enqueue(object : Callback<MemeResponse> {
                    override fun onResponse(
                        call: Call<MemeResponse>,
                        response: Response<MemeResponse>
                    ) {
                        if (response.body() != null) {
                            intent = Intent(
                                applicationContext,
                                ActivityMostrarMemeId::class.java
                            ).apply {
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


    fun comprobarDatos(): Boolean
    {
        return  !binding.textoNombre2.text.equals("") &&
                !binding.textoSup2.text.equals("") &&
                !binding.textoInf2.text.equals("") &&
                !binding.textoUrl2.text.equals("") &&
                !binding.textoTag2.text.equals("")
    }
}