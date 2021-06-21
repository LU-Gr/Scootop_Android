package fr.scootop.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Club: HydraResource() {
    @Expose
    @SerializedName("id")
    var id: Int = 0
    @Expose
    @SerializedName("name")
    var name: String = ""
    @Expose
    @SerializedName("country")
    var country: Country? = null
    override fun toString(): String {
        return name
    }
}