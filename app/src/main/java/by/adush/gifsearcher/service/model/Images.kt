package by.adush.gifsearcher.service.model


import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original")
    val original: Original
)