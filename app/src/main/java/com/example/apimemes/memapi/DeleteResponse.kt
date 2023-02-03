package com.example.apimemes.memapi

import com.google.gson.annotations.SerializedName

data class DeleteResponse(
    @SerializedName("deleted") var deleted: Boolean
)