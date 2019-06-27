package com.task.mkedra.popularmovies.Data.Models

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>,
    val page: Int
)