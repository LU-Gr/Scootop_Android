package fr.scootop.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Position {

    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("name")
    var name: String = ""

    @Expose
    @SerializedName("short_name")
    var shortName: String? = null

    override fun toString(): String {
        return name
    }
}
