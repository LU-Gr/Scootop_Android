package fr.scootop.data.model.youtube
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class YTSearchListResponse: YTObject() {
    @Expose
    @SerializedName("nextPageToken")
    var nextPageToken: String? = null
    @Expose
    @SerializedName("regionCode")
    var regionCode: String? = null
    @Expose
    @SerializedName("pageInfo")
    var pageInfo: YTPageInfo? = null
    @Expose
    @SerializedName("items")
    var items: Array<YTSearchResult> = emptyArray()
}