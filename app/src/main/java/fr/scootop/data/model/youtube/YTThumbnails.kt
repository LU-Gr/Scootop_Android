package fr.scootop.data.model.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class YTThumbnails {

    @Expose
    @SerializedName("default")
    var default: YTThumbnail? = null

    @Expose
    @SerializedName("medium")
    var medium: YTThumbnail? = null

    @Expose
    @SerializedName("high")
    var high: YTThumbnail? = null

}