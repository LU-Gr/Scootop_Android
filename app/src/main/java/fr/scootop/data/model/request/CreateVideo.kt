package fr.scootop.data.model.request
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class CreateVideo(@Expose @SerializedName("youtubeId") val youtubeId: String)