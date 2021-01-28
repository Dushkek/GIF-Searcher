package by.adush.gifsearcher.service.response

import by.adush.gifsearcher.service.model.GifModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GIFSSearchResponse {

    @SerializedName("data")
    @Expose
    private val gifs: List<GifModel> = listOfNotNull()


    fun getGifs(): List<GifModel> = gifs


    override fun toString(): String {
        return "GIFSSearchResponse{gifs=$gifs}"
    }


}