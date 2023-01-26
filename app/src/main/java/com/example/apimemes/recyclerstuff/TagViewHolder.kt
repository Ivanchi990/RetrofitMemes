package com.example.apimemes.recyclerstuff

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.R
import com.example.apimemes.memapi.TagResponse

class TagViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    private var idTag: TextView = view.findViewById<TextView>(R.id.idTag)
    private var txtTag: TextView = view.findViewWithTag<TextView>(R.id.txtTag)

    fun render(tagResponse: TagResponse)
    {
        idTag.text = tagResponse.idTag.toString()

        if(tagResponse.texto != "" && tagResponse.texto != null)
            txtTag.text = tagResponse.texto
        else
            txtTag.text = "NULL"
    }
}