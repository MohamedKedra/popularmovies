package com.task.mkedra.popularmovies.UI.Main

import com.task.mkedra.popularmovies.Data.Models.Movie

interface MainCallback {

    interface ViewCallback{

        fun receiveMovies(movies : List<Movie>)
    }

    interface PresenterCallback{

        fun sendType(key : String)
    }
}