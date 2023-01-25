package com.example.apimemes.actividadesapi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.apimemes.MainActivity
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityMainBinding
import com.example.apimemes.databinding.ActivityMostrarMemeIdBinding
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.squareup.picasso.Picasso
import retrofit2.*

class ActivityMostrarMemeId : AppCompatActivity()
{
    lateinit var binding: ActivityMostrarMemeIdBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarMemeIdBinding.inflate(layoutInflater)

        var id = intent.getStringExtra("id")

        mostrarMeme(id!!)

        binding.btnHome.setOnClickListener{
            casita()
        }

        setContentView(binding.root)
    }

    fun mostrarMeme(id: String)
    {
        MemeRetrofitInstance.api.getMeme("/meme?id=$id")
            .enqueue(object : Callback<MemeResponse> {
                override fun onResponse(
                    call: Call<MemeResponse>,
                    response: Response<MemeResponse>
                ) {
                    if (response.body() != null)
                    {
                        binding.tuedittext2.text = response.body()?.titInf
                        binding.tuedittext.text = response.body()?.titSup

                        val url = response.body()?.url

                        Picasso.get()
                            .load(url)
                            .error(R.drawable.makina_linkedin)
                            .fit()
                            .centerCrop()
                            .into(binding.tuimageview)

                        binding.progressBar.isVisible = false
                    }
                        else
                    {
                        return
                    }
                }

                override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun casita()
    {
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }
}