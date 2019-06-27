package com.task.mkedra.popularmovies.Data.Models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val poster: String,
    val overview: String,
    @SerializedName("vote_average")
    val rate: String,
    @SerializedName("release_date")
    val date: String,
    val popularity: Double,
    @SerializedName("backdrop_path")
    val backdrop: String,
    @SerializedName("original_language")
    val language : String,
    @SerializedName("vote_count")
    val count : Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(overview)
        parcel.writeString(rate)
        parcel.writeString(date)
        parcel.writeDouble(popularity)
        parcel.writeString(backdrop)
        parcel.writeString(language)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}