package com.task.mkedra.popularmovies.UI.Main


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Utils
import com.task.mkedra.popularmovies.R
import com.task.mkedra.popularmovies.UI.MovieAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment(),MainCallback.ViewCallback{

    lateinit var recycler : RecyclerView

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        recycler = view.findViewById(R.id.rv_movies)
        recycler.layoutManager = GridLayoutManager(activity,2)
        adapter.context = activity?.applicationContext!!
        presenter.setView(this)
        presenter.sendType(Utils.Popular)
        return view
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun receiveMovies(movies: List<Movie>) {
        adapter.movies = movies
        recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_main,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.mi_popular -> presenter.sendType(Utils.Popular)
            R.id.mi_rated -> presenter.sendType(Utils.Rated)
        }
        return super.onOptionsItemSelected(item)
    }
}