package net.vinid.moviedb.data.remote.respone

import com.google.gson.annotations.SerializedName

data class ListMovieRespone (
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<MovieRespone>,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int
)