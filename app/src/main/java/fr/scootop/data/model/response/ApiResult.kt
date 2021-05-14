package fr.scootop.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResult {

    @Expose
    @SerializedName("error")
    var error: String? = null

    @Expose
    @SerializedName("message")
    var message: String? = null

}