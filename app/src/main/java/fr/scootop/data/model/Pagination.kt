package fr.scootop.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Pagination<T> : HydraResource() {
    @Expose
    @SerializedName("hydra:member")
    var members: Array<T>? = null
    @Expose
    @SerializedName("hydra:totalItems")
    var totalItems: Int = 0
}