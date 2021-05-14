package fr.scootop.data.model.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class YTSnippet {

    @Expose
    @SerializedName("publishedAt")
    var publishedAt: Date? = null

    @Expose
    @SerializedName("channelId")
    var channelId: String? = null

    @Expose
    @SerializedName("channelTitle")
    var channelTitle: String? = null

    @Expose
    @SerializedName("liveBroadcastContent")
    var liveBroadcastContent: String? = null

    @Expose
    @SerializedName("title")
    var title: String = ""

    @Expose
    @SerializedName("description")
    var description: String = ""

    @Expose
    @SerializedName("thumbnails")
    var thumbnails: YTThumbnails? = null

}