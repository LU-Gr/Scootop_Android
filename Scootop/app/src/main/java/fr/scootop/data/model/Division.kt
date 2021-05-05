package fr.scootop.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Division : HydraResource() {

    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("name")
    var name: String = ""

    @Expose
    @SerializedName("short_name")
    var shortName: String? = null

    @Expose
    @SerializedName("country")
    var countryIri: String? = null

    @Expose
    @SerializedName("sort")
    var sort: Int = 0

    override fun toString(): String {
        return name
    }
}