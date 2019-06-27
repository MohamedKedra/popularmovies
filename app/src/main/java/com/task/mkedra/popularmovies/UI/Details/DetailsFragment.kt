package com.task.mkedra.popularmovies.UI.Details


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Models.Trailer
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.R
import com.task.mkedra.popularmovies.UI.TrailerAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class DetailsFragment : Fragment() ,DetailsCallback.ViewCallback{

    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var presenter: DetailsPresenter

    @Inject
    lateinit var adapter: TrailerAdapter

    companion object {

        fun getInstance(movie: Movie?): DetailsFragment {

            val details = DetailsFragment()
            val b = Bundle()
            b.putParcelable(Utils.Movie,movie)
            details.arguments = b
            return details
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v =  inflater.inflate(R.layout.fragment_details, container, false)
        recyclerView = v.findViewById(R.id.rv_trailers)
        adapter.context = activity?.applicationContext!!
        presenter.setView(this)
        return v
    }

    override fun receiveTrailers(trailers: List<Trailer>) {
        adapter.trailers = trailers
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onStart() {
        super.onStart()
        val movie = arguments?.getParcelable<Movie>(Utils.Movie)
        Glide.with(this!!.activity!!).load(Utils.ImageBase+movie?.backdrop).into(iv_bg)
        Glide.with(this!!.activity!!).load(Utils.ImageBaseSmall+movie?.poster).into(iv_poster)
        if (movie != null){
            tv_title.text = movie.title
            tv_date.text = movie.date
            tv_overview.text = movie.overview
            tv_lang.text = movie.language
            tv_popularity.text = movie.popularity.toString().split(".")[0]+"."
            tv_top_rate.text = movie.count.toString()
            tv_rate.text = movie.rate
            adapter.poster = movie.poster
            adapter.drop = movie.backdrop
            presenter.send(movie.id,Utils.key)
        }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
