package com.task.mkedra.popularmovies.UI

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.task.mkedra.popularmovies.Data.Models.Trailer
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.R
import javax.inject.Inject

class TrailerAdapter @Inject constructor(): RecyclerView.Adapter<TrailerAdapter.TrailerHolder>() {

    lateinit var trailers: List<Trailer>
        set

    lateinit var context : Context
        set

    lateinit var poster : String
        set

    lateinit var drop : String
        set

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TrailerHolder {
        return TrailerHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trailer, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return trailers.size
    }

    override fun onBindViewHolder(holder: TrailerHolder, position: Int) {

        val trailer = trailers.get(position)
        holder.name.text = trailer.name
        holder.site.text = trailer.site
        holder.size.text = trailer.size.toString()+"HD"
        if (position % 2 == 0){
            Glide.with(context).load(Utils.ImageBaseSmall+poster).into(holder.image)
        }else{
            Glide.with(context).load(Utils.ImageBase+drop).into(holder.image)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(Utils.Youtube+trailer.key))
            context.startActivity(intent)
        }
    }

    class TrailerHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var image : ImageView
        var name : TextView
        var site : TextView
        var size : TextView

        init {
            image = itemView.findViewById(R.id.iv_trailer)
            name = itemView.findViewById(R.id.tv_name)
            site = itemView.findViewById(R.id.tv_site)
            size = itemView.findViewById(R.id.tv_size)
        }
    }
}