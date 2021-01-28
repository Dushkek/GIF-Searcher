package by.adush.gifsearcher.service.model


import com.google.gson.annotations.SerializedName

data class GifModel(
    @SerializedName("images")
    val images: Images,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)