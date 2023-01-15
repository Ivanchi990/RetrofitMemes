package com.example.apimemes.recyclerstuff

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.R
import com.example.apimemes.memapi.MemeResponse

class MemeAdapter(private val onClickListener: (Int) -> Unit ): RecyclerView.Adapter<MemeViewHolder>()
{
    private lateinit var context: Context
    lateinit var memes: List<MemeResponse>

    fun MemeAdapter(context: Context, memes: List<MemeResponse>)
    {
        this.context = context
        this.memes = memes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MemeViewHolder(layoutInflater.inflate(R.layout.meme_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return memes.size
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int)
    {
        holder.render(memes[position], onClickListener)
    }
}
