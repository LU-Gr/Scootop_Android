package fr.scootop.data.model.youtube

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class YTSearchResult: YTObject() {

    @Expose
    @SerializedName("id")
    var id: YTId? = null

    @Expose
    @SerializedName("snippet")
    var snippet: YTSnippet? = null

}