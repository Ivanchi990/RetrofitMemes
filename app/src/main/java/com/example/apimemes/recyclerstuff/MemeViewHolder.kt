package com.example.apimemes.recyclerstuff

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.R
import com.example.apimemes.memapi.MemeResponse

class MemeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var idMeme = itemView.findViewById<TextView>(R.id.idTag)
    var nombreMeme = itemView.findViewById<TextView>(R.id.txtTag2)
    var mostrarMeme = itemView.findViewById<TextView>(R.id.btnMostrar)

    fun render(meme: MemeResponse, onClickListener: (Int) -> Unit)
    {
        idMeme.text = meme.idMeme.toString()
        nombreMeme.text = meme.nombreMeme

        mostrarMeme.setOnClickListener{
            onClickListener(meme.idMeme)
        }
    }
}