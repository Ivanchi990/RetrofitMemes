package com.example.apimemes.actividadesapi

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.apimemes.databinding.ActivityCrearMemeBinding
import com.example.apimemes.memapi.Meme
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.example.apimemes.memapi.TagResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityCrearMeme : AppCompatActivity()
{
    private lateinit var binding: ActivityCrearMemeBinding
    private lateinit var tags: List<TagResponse>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMemeBinding.inflate(layoutInflater)

        rellenarSpiner()

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
                    dameId()
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

    fun rellenarSpiner()
    {
        MemeRetrofitInstance.api.getTags("/tag")
            .enqueue(object : Callback<List<TagResponse>>{
                override fun onResponse(call: Call<List<TagResponse>>, response: Response<List<TagResponse>>) {
                    if(response.body() != null){

                        tags = response.body()!!

                        var lista = ArrayList<String>()

                        for(t in tags)
                        {
                            lista.add(t.texto)
                        }

                        binding.spinner.adapter = ArrayAdapter(applicationContext, R.layout.simple_spinner_dropdown_item, lista)
                    }
                }

                override fun onFailure(call: Call<List<TagResponse>>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }

            })

    }

    fun dameId(): String
    {
        var num = "0"

        for(t in tags)
        {
            if(t.texto.equals(binding.spinner.selectedItem.toString()))
            {
                num = t.idTag.toString()
            }
        }

        return num
    }

    fun datosRellenos(): Boolean
    {
        return  !(binding.textoNombre.text.equals("") &&
                binding.textoSup.text.equals("") &&
                binding.textoInf.text.equals("") &&
                binding.textoUrl.text.equals(""))
    }
}