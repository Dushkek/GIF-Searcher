package by.adush.gifsearcher.service.request

import by.adush.gifsearcher.service.response.GIFSSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GIFSAPI {

    // https://api.giphy.com/v1/gifs/search?api_key=W9USqEuQbIZIxzeTYDdSnX8h428oMUyW&q=(query)&limit=25&rating=g
    @GET("gifs/search")
    fun searchGif(
        @Query("api_key")
        key : String,
        @Query("q")
        query: String,
        @Query("limit")
        limit : Int,
        @Query("rating")
        rating : String
    ):Call<GIFSSearchResponse>

    // https://api.giphy.com/v1/gifs/trending?api_key=AZ3DtmH3Z2j38hP4dRSdZ90zS97Afrcz&limit=25&rating=g
    @GET("gifs/trending")
    fun trendingGif(
        @Query("api_key")
        key : String,
        @Query("limit")
        limit : Int,
        @Query("rating")
        rating : String
    ):Call<GIFSSearchResponse>
}