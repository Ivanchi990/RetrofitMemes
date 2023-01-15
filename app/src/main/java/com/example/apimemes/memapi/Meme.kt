package com.example.apimemes.memapi

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class Meme(
    @SerializedName("nombre") var nombreMeme: String,
    @SerializedName("tInferior") var titInf: String,
    @SerializedName("tSuperior") var titSup: String,
    @SerializedName("url") var url: String,
    @SerializedName("tags") var tags: String
)
