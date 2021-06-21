package fr.scootop.data.model.youtube
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class YTPageInfo {
    @Expose
    @SerializedName("totalResults")
    var totalResults: Int = 0
    @Expose
    @SerializedName("resultsPerPage")
    var resultsPerPage: Int = 0
}