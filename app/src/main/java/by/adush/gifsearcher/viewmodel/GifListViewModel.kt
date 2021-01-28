package by.adush.gifsearcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import by.adush.gifsearcher.service.model.GifModel
import by.adush.gifsearcher.service.repositories.GifRepository

class GifListViewModel : ViewModel() {

    private val gifRepository =  GifRepository.instance

    fun getSearchGifs(): LiveData<List<GifModel>> = gifRepository.getSeacrhGifs()

    fun getTrendingGifs(): LiveData<List<GifModel>> = gifRepository.getTrendingGifs()

    fun searchGifsApi(query: String, limit : Int, rating : String){
        gifRepository.searchGifsApi(query, limit, rating)
    }

    fun trendingGifsApi(limit : Int, rating : String){
        gifRepository.trendingGifsApi(limit, rating)
    }
}