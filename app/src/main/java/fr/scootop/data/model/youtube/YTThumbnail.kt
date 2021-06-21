package fr.scootop.data.model.youtube
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class YTThumbnail {
    @Expose
    @SerializedName("url")
    var url: String = ""
    @Expose
    @SerializedName("width")
    var width: Int = 0
    @Expose
    @SerializedName("height")
    var height: Int = 0
}