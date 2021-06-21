package fr.scootop.data.model
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*
class User() : Parcelable {

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("first_name")
    var firstName: String? = null

    @SerializedName("last_name")
    var lastName: String? = null

    @SerializedName("gender")
    var gender: String? = null

    @SerializedName("nationality_country")
    var nationalityCountry: Country? = null

    @SerializedName("origin_country")
    var originCountry: Country? = null

    @SerializedName("birth_date")
    var birthDate: Date? = null

    @SerializedName("license")
    var license: String? = null

    @SerializedName("comment")
    var comment: String? = null

    @SerializedName("picture_name")
    var pictureName: String? = null

    @SerializedName("is_following")
    var isFollowing: Boolean? = null // null when I got my own info

    @SerializedName("shortlist_item_id")
    var shortlistItemId: Int? = null // non-null when isFollowing is true, null otherwise

    @SerializedName("type")
    var type: String? = null

    @SerializedName("type_id")
    var typeId: Int? = null
    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        firstName = parcel.readString()
        lastName = parcel.readString()
        gender = parcel.readString()
        license = parcel.readString()
        comment = parcel.readString()
        pictureName = parcel.readString()
        isFollowing = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        shortlistItemId = parcel.readValue(Int::class.java.classLoader) as? Int
        type = parcel.readString()
        typeId = parcel.readValue(Int::class.java.classLoader) as? Int
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(gender)
        parcel.writeString(license)
        parcel.writeString(comment)
        parcel.writeString(pictureName)
        parcel.writeValue(isFollowing)
        parcel.writeValue(shortlistItemId)
        parcel.writeString(type)
        parcel.writeValue(typeId)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }
        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
