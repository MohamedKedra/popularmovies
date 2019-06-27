package com.task.mkedra.popularmovies.UI.Details

import com.task.mkedra.popularmovies.Data.Models.Movie
import com.task.mkedra.popularmovies.Data.Models.Trailer

interface DetailsCallback {

    interface ViewCallback{

        fun receiveTrailers(trailers : List<Trailer>)
    }

    interface PresenterCallback{

        fun send(id : Int,key : String)
    }
}