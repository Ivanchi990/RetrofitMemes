package com.example.apimemes.memapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MemeService {
    @GET
    fun getMeme(@Url url:String): Call<MemeResponse>
}