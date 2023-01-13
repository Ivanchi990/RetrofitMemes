package com.example.apimemes.memapi

import com.google.gson.annotations.SerializedName

data class MemeResponse(
    @SerializedName("idMeme") var idMeme: Int,
    @SerializedName("titInf") var titInf: String,
    @SerializedName("titSup") var titSup: String,
    @SerializedName("url") var url: String
)

