package by.adush.gifsearcher.service.model


import com.google.gson.annotations.SerializedName

data class Original(
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("mp4")
    val mp4: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("webp")
    val webp: String,
    @SerializedName("width")
    val width: String
)