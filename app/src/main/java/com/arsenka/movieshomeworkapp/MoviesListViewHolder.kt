package com.arsenka.movieshomeworkapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.recyclerview.widget.RecyclerView

class MoviesListAdapter(private val list: List<MoviesListItem>) :
    RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>() {
    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class MoviesListViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val tvTitleName: TextView = itemView.findViewById(R.id.tvTitleName)
        val tvAge: TextView = itemView.findViewById(R.id.tvAge)
        val tvMovieGenres: TextView = itemView.findViewById(R.id.tvMovieGenres)
        val tvReviews: TextView = itemView.findViewById(R.id.tvReviews)
        val tvDurationFilm: TextView = itemView.findViewById(R.id.tvDurationFilm)
        val ivFavourite: ImageView = itemView.findViewById(R.id.ivLike)
        val ivPoster: ImageView = itemView.findViewById(R.id.ivMoviePoster)
        val firstStar: ImageView = itemView.findViewById(R.id.tvFirstStar)
        val secondStar: ImageView = itemView.findViewById(R.id.tvSecondStar)
        val thirdStar: ImageView = itemView.findViewById(R.id.tvThirdStar)
        val fourStar: ImageView = itemView.findViewById(R.id.tvFourStar)
        val fiveStar: ImageView = itemView.findViewById(R.id.tvFiveStar)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        return MoviesListViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.tvTitleName.text = list[position].titleName
        holder.tvAge.text = list[position].age
        holder.tvMovieGenres.text = list[position].genres
        holder.tvReviews.text = list[position].reviews
        holder.tvDurationFilm.text = list[position].time
        if (list[position].ivFavourite)
            holder.ivFavourite.setImageResource(R.drawable.ic_favourite_pink)
        else
            holder.ivFavourite.setImageResource(R.drawable.ic_favourite_grey)
        holder.ivPoster.setImageResource(list[position].ivPoster)
        when (list[position].rating) {
            1 -> {
                holder.firstStar.setImageResource(R.drawable.ic_star_icon)
                holder.secondStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.thirdStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.fourStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.fiveStar.setImageResource(R.drawable.ic_star_icon_grey)
            }
            2 -> {
                holder.firstStar.setImageResource(R.drawable.ic_star_icon)
                holder.secondStar.setImageResource(R.drawable.ic_star_icon)
                holder.thirdStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.fourStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.fiveStar.setImageResource(R.drawable.ic_star_icon_grey)
            }
            3 -> {
                holder.firstStar.setImageResource(R.drawable.ic_star_icon)
                holder.secondStar.setImageResource(R.drawable.ic_star_icon)
                holder.thirdStar.setImageResource(R.drawable.ic_star_icon)
                holder.fourStar.setImageResource(R.drawable.ic_star_icon_grey)
                holder.fiveStar.setImageResource(R.drawable.ic_star_icon_grey)
            }
            4 -> {
                holder.firstStar.setImageResource(R.drawable.ic_star_icon)
                holder.secondStar.setImageResource(R.drawable.ic_star_icon)
                holder.thirdStar.setImageResource(R.drawable.ic_star_icon)
                holder.fourStar.setImageResource(R.drawable.ic_star_icon)
                holder.fiveStar.setImageResource(R.drawable.ic_star_icon_grey)
            }
            5 -> {
                holder.firstStar.setImageResource(R.drawable.ic_star_icon)
                holder.secondStar.setImageResource(R.drawable.ic_star_icon)
                holder.thirdStar.setImageResource(R.drawable.ic_star_icon)
                holder.fourStar.setImageResource(R.drawable.ic_star_icon)
                holder.fiveStar.setImageResource(R.drawable.ic_star_icon)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}

data class MoviesListItem(
    val titleName: String,
    val age: String,
    val genres: String,
    val reviews: String,
    val time: String,
    val ivFavourite: Boolean,
    @DrawableRes val ivPoster: Int,
    @IntRange(from = 0, to = 5) val rating: Int
)

