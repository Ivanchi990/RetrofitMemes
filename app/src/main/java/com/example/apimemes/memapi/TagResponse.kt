package com.example.apimemes.memapi

import com.google.gson.annotations.SerializedName

data class TagResponse(
    @SerializedName("idTag") var idTag: Int,
    @SerializedName("texto") var texto: String
)
