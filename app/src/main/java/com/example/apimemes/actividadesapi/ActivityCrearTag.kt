package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apimemes.MainActivity
import com.example.apimemes.databinding.ActivityCrearTagBinding
import com.example.apimemes.memapi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityCrearTag : AppCompatActivity()
{
    private lateinit var binding: ActivityCrearTagBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearTagBinding.inflate(layoutInflater)

        binding.btnCrearTag.setOnClickListener {
            crearTag()
        }

        setContentView(binding.root)
    }


    fun crearTag()
    {
        if(!binding.edNameTag.text.equals(""))
        {
            MemeRetrofitInstance.api.postTag(
                "/tag", Tag(
                    binding.edNameTag.text.toString()
                )
            )
                .enqueue(object : Callback<TagResponse> {
                    override fun onResponse(
                        call: Call<TagResponse>,
                        response: Response<TagResponse>
                    ) {
                        if (response.body() != null)
                        {
                            Toast.makeText(applicationContext, "El tag se ha creado correctamente", Toast.LENGTH_LONG).show()
                            intent = Intent(applicationContext, MainActivity::class.java)

                            startActivity(intent)
                        }
                        else
                        {
                            return
                        }
                    }

                    override fun onFailure(call: Call<TagResponse>, t: Throwable)
                    {
                        Log.d("TAG", t.message.toString())
                    }
                })
        }
        else
        {
            Toast.makeText(this, "Vaya, parece que no se ha podido crear el tag", Toast.LENGTH_SHORT)
        }
    }
}