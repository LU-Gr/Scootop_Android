package fr.scootop.data.model.youtube
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class YTId: YTObject() {
    @Expose
    @SerializedName("videoId")
    var videoId: String = ""
}