package com.example.apimemes.actividadesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apimemes.MainActivity
import com.example.apimemes.R
import com.example.apimemes.databinding.ActivityMostrarMemesBinding
import com.example.apimemes.memapi.MemeResponse
import com.example.apimemes.memapi.MemeRetrofitInstance
import com.example.apimemes.recyclerstuff.MemeAdapter
import com.squareup.picasso.Picasso
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMostrarMemes : AppCompatActivity()
{
    private lateinit var binding: ActivityMostrarMemesBinding
    private lateinit var memeAdapter: MemeAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarMemesBinding.inflate(layoutInflater)

        iniciarRecycler()

        binding.button.setOnClickListener{
            volverCasa()
        }

        setContentView(binding.root)
    }

    fun iniciarRecycler()
    {
        MemeRetrofitInstance.api.getMemes("/meme/list")
            .enqueue(object : Callback<List<MemeResponse>> {
                override fun onResponse(
                    call: Call<List<MemeResponse>>,
                    response: Response<List<MemeResponse>>
                ) {
                    if (response.body() != null)
                    {
                        val recyclerView = binding.rvMemes
                        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                        memeAdapter = MemeAdapter(
                            onClickListener = {id -> dameMeme(id)}
                        )

                        memeAdapter.MemeAdapter(applicationContext, response.body()!!)

                        recyclerView.adapter = memeAdapter
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "Vaya parece que no me puedo conectar a la api", Toast.LENGTH_LONG).show()
                        volverCasa()
                    }
                }

                override fun onFailure(call: Call<List<MemeResponse>>, t: Throwable)
                {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun dameMeme(id: Int)
    {
        intent = Intent(this, ActivityMostrarMemeId::class.java).apply {
            putExtra("id", id.toString())
        }

        startActivity(intent)
    }


    fun volverCasa()
    {
        intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }
}