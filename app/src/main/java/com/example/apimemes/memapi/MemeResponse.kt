package com.example.apimemes.memapi

import com.google.gson.annotations.SerializedName

data class MemeResponse(
    @SerializedName("idMeme") var idMeme: Int,
    @SerializedName("nombre") var nombreMeme: String,
    @SerializedName("tInferior") var titInf: String,
    @SerializedName("tSuperior") var titSup: String,
    @SerializedName("url") var url: String
)