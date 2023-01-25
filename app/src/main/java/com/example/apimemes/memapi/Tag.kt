package com.example.apimemes.memapi

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("tagNombre")var tagNombre: String
)
