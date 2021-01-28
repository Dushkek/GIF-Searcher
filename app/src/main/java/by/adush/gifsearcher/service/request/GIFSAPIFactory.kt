package by.adush.gifsearcher.service.request


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "https://api.giphy.com/v1/"

const val KEY_VALUE = "AZ3DtmH3Z2j38hP4dRSdZ90zS97Afrcz"

object GIFSAPIFactory {


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    private val gifsApi : GIFSAPI = retrofit.create()

    fun getGIFSAPI():GIFSAPI{
        return gifsApi
    }


}