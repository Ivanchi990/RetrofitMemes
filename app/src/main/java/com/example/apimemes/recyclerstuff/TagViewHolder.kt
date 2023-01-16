package com.example.apimemes.recyclerstuff

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.R
import com.example.apimemes.memapi.TagResponse

class TagViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    val idTag = view.findViewById<TextView>(R.id.idTag)
    val txtTag = view.findViewWithTag<TextView>(R.id.txtTag)

    fun render(tagResponse: TagResponse)
    {
        idTag.text = tagResponse.idTag.toString()
        txtTag.text = tagResponse.texto
    }
}