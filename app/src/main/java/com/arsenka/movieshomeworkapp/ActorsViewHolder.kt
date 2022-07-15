package com.arsenka.movieshomeworkapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorsAdapter(private val list: List<ActorsListItem>) :
    RecyclerView.Adapter<ActorsAdapter.ActorsViewHolder>() {
    class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val ivImage: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_actors, parent, false)
        return ActorsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) = with(holder) {
        tvName.text = list[position].name
        ivImage.setImageResource(list[position].imageId)
    }

    override fun getItemCount(): Int = list.size
}

data class ActorsListItem(
    val name: String,
    val imageId: Int
)
