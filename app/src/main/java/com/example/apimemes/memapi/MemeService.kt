package com.example.apimemes.memapi

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url

interface MemeService {
    @GET
    fun getMeme(@Url url:String): Call<MemeResponse>

    @GET
    fun getMemes(@Url url: String): Call<List<MemeResponse>>

    @POST
    fun postMeme(@Url url: String, @Body meme: Meme): Call<MemeResponse>

    @PUT
    fun editMeme(@Url url: String, @Body meme: Meme): Call<MemeResponse>

    @GET
    fun getTags(@Url url: String): Call<List<TagResponse>>

    @POST
    fun postTag(@Url url: String, @Body tag: Tag): Call<TagResponse>
}