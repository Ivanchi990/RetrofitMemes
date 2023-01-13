package com.example.apimemes.memapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MemeRetrofitInstance {
    val api: MemeService by lazy {
        Retrofit.Builder()
            .baseUrl("https://damemeapi.000webhostapp.com/doc")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MemeService::class.java)
    }
}
