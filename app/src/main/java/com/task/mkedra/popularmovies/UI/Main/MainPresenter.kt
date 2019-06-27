package com.task.mkedra.popularmovies.UI.Main

import android.util.Log
import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Models.MovieResponse
import com.task.mkedra.popularmovies.Data.Network.ClientApi
import com.task.mkedra.popularmovies.Data.Utils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : MainCallback.PresenterCallback {

    private lateinit var movies : List<Movie>
    @Inject
    lateinit var api: ClientApi

    private lateinit var listener : MainCallback.ViewCallback

    fun setView(m  :MainCallback.ViewCallback){
        listener = m
    }

    override fun sendType(type: String) {

        if (type.equals(Utils.Popular)) {

            api.getPopularMovies(Utils.key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        }else{

            api.getTopMovies(Utils.key).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        }
    }

    private val observer = object : Observer<MovieResponse> {
        override fun onComplete() {

            Log.d("fff","Errrrr")
            listener.receiveMovies(movies)
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(movieResponse: MovieResponse) {
            movies = ArrayList(movieResponse.movies)
        }

        override fun onError(e: Throwable) {
        }
    }
}