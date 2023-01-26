package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.MainActivity
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityMostrarTagsBinding
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.example.apimemes.memapi.TagResponse
import com.example.apimemes.recyclerstuff.MemeAdapter
import com.example.apimemes.recyclerstuff.TagAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMostrarTags : AppCompatActivity()
{
    private lateinit var binding: ActivityMostrarTagsBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarTagsBinding.inflate(layoutInflater)

        iniciarRecycler()

        binding.button2.setOnClickListener{
            volverCasa()
        }

        setContentView(binding.root)
    }


    fun iniciarRecycler()
    {
        MemeRetrofitInstance.api.getTags("/tag")
            .enqueue(object : Callback<List<TagResponse>>
            {
                override fun onResponse(
                    call: Call<List<TagResponse>>,
                    response: Response<List<TagResponse>>)
                {
                    if (response.body() != null)
                    {
                        val recyclerView = binding.rvTags
                        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                        recyclerView.adapter = TagAdapter(response.body()!!)
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "Vaya parece que no me puedo conectar a la api", Toast.LENGTH_LONG).show()
                        volverCasa()
                    }
                }

                override fun onFailure(call: Call<List<TagResponse>>, t: Throwable)
                {
                    Log.d("TAG", t.message.toString())
                }
            })
    }


    fun volverCasa()
    {
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }
}