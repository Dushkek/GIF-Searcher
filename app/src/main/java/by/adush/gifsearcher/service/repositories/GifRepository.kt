package by.adush.gifsearcher.service.repositories

import androidx.lifecycle.LiveData
import by.adush.gifsearcher.service.model.GifModel
import by.adush.gifsearcher.service.request.GifApiClient

class GifRepository {

    private val gifApiClient  = GifApiClient.instance

    companion object {

        var instance = GifRepository()
    }

    fun getSeacrhGifs() : LiveData<List<GifModel>> = gifApiClient.getSeacrhGifs()

    fun getTrendingGifs() : LiveData<List<GifModel>> = gifApiClient.getTrendingGifs()



    fun searchGifsApi(query: String,limit : Int, rating : String) {
        gifApiClient.searchGifsApi(query, limit, rating)
    }


    fun trendingGifsApi(limit : Int, rating : String) {
        gifApiClient.trendingGifsApi(limit,rating)
    }

}
