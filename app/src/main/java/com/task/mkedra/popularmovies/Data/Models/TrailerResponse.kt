package com.task.mkedra.popularmovies.Data.Models

import com.google.gson.annotations.SerializedName

class TrailerResponse(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("results")
    val trailers: List<Trailer>)