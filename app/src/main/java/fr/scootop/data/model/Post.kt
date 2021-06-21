package fr.scootop.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Post: HydraResource() {
    @Expose
    @SerializedName("address")
    var address: String = ""
    @Expose
    @SerializedName("date")
    var date: String = ""
    @Expose
    @SerializedName("text")
    var text: String = ""
    
}