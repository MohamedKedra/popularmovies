package com.task.mkedra.popularmovies.Data.Network

import com.task.mkedra.popularmovies.Data.Models.MovieResponse
import com.task.mkedra.popularmovies.Data.Models.TrailerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClientApi {

    @GET("popular")
    fun getPopularMovies(@Query("api_key") key: String) : Observable<MovieResponse>

    @GET("top_rated")
    fun getTopMovies(@Query("api_key") key: String) : Observable<MovieResponse>

    @GET("{id}/videos")
    fun getTrailers(@Path("id") id : Int,@Query("api_key") key : String)  : Observable<TrailerResponse>
}