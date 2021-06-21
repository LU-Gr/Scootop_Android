package fr.scootop.data.model.youtube
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
open class YTObject {
    @Expose
    @SerializedName("kind")
    var kind: String = ""
    @Expose
    @SerializedName("etag")
    var etag: String? = null
}