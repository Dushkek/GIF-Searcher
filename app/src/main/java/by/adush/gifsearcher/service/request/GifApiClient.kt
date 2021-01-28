package by.adush.gifsearcher.service.request

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.adush.gifsearcher.service.model.GifModel
import by.adush.gifsearcher.service.response.GIFSSearchResponse
import kotlinx.coroutines.*
import retrofit2.*
import java.util.ArrayList

class GifApiClient {

    private val searchGifs: MutableLiveData<List<GifModel>> = MutableLiveData()


    private val trendingGifs : MutableLiveData<List<GifModel>> = MutableLiveData()

    companion object {
        var instance = GifApiClient()
    }

    fun getSeacrhGifs() : LiveData<List<GifModel>> = searchGifs

    fun getTrendingGifs() : LiveData<List<GifModel>> = trendingGifs


    fun searchGifsApi(query: String,limit : Int, rating : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseCall: Call<GIFSSearchResponse> = getSeacrhGifsRequest(query, limit, rating)

            withContext(Dispatchers.Main) {

                responseCall.enqueue(object : Callback<GIFSSearchResponse> {

                    override fun onResponse(call: Call<GIFSSearchResponse>, response: Response<GIFSSearchResponse>) {
                        if (response.isSuccessful) {

                            val listOfGifs: List<GifModel> = ArrayList(response.body()!!.getGifs())
                            searchGifs.postValue(listOfGifs)

                        } else {
                            Log.v("Tag", "Error number: " + response.errorBody().toString())
                        }
                    }

                    override fun onFailure(call: Call<GIFSSearchResponse>, t: Throwable) {
                        Log.e("Tag", "FATAL ERROR")
                    }

                })
            }
        }

    }


    fun trendingGifsApi(limit : Int, rating : String) {
        CoroutineScope(Dispatchers.IO).launch {
            val responseCall: Call<GIFSSearchResponse> = getTrendingGifsRequest(limit, rating)

            withContext(Dispatchers.Main) {

                responseCall.enqueue(object : Callback<GIFSSearchResponse> {

                    override fun onResponse(call: Call<GIFSSearchResponse>, response: Response<GIFSSearchResponse>) {
                        if (response.isSuccessful) {

                            val listOfGifs: List<GifModel> = ArrayList(response.body()!!.getGifs())
                            trendingGifs.postValue(listOfGifs)

                        } else {
                            Log.v("Tag", "Error number: " + response.errorBody().toString())
                        }
                    }

                    override fun onFailure(call: Call<GIFSSearchResponse>, t: Throwable) {
                        Log.e("Tag", "FATAL ERROR")
                    }

                })
            }
        }

    }

    private fun getSeacrhGifsRequest(query: String, limit : Int, rating : String ) : Call<GIFSSearchResponse> = GIFSAPIFactory.getGIFSAPI()
            .searchGif(
                KEY_VALUE,
                query,
                limit,
                rating)

    private fun getTrendingGifsRequest(limit : Int, rating : String ) : Call<GIFSSearchResponse> = GIFSAPIFactory.getGIFSAPI()
            .trendingGif(
                KEY_VALUE,
                limit,
                rating)

    }






