package com.task.mkedra.popularmovies.UI

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.R
import com.task.mkedra.popularmovies.UI.Details.DetailsActivity
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    lateinit var context: Context
        set

    lateinit var movies: List<Movie>
        set

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): MovieHolder {
        return MovieHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        Glide.with(context).load(Utils.ImageBase + movies.get(position).poster).into(holder.poster)
        holder.title.text = movies.get(position).title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(Utils.Movie, movies.get(position))
            context.startActivity(intent)
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var poster: ImageView
        var title: TextView

        init {
            poster = itemView.findViewById(R.id.iv_poster)
            title = itemView.findViewById(R.id.tv_title)
        }
    }
}