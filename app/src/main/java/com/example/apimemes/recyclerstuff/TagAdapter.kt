package com.example.apimemes.recyclerstuff

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apimemes.R
import com.example.apimemes.memapi.TagResponse

class TagAdapter(private val tags: List<TagResponse>): RecyclerView.Adapter<TagViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TagViewHolder(layoutInflater.inflate(R.layout.tag_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return tags.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int)
    {
        holder.render(tags[position])
    }
}