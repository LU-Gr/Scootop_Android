package fr.scootop.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.Date

class User() : Parcelable {

    @Expose
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("first_name")
    var firstName: String? = null

    @Expose
    @SerializedName("last_name")
    var lastName: String? = null

    @Expose
    @SerializedName("gender")
    var gender: String? = null

    @Expose
    @SerializedName("nationality_country")
    var nationalityCountry: Country? = null

    @Expose
    @SerializedName("origin_country")
    var originCountry: Country? = null

    @Expose
    @SerializedName("birth_date")
    var birthDate: Date? = null

    @Expose
    @SerializedName("license")
    var license: String? = null

    @Expose
    @SerializedName("comment")
    var comment: String? = null

    @Expose
    @SerializedName("picture_name")
    var pictureName: String? = null

    @Expose
    @SerializedName("is_following")
    var isFollowing: Boolean? = null // null when I got my own info

    @Expose
    @SerializedName("shortlist_item_id")
    var shortlistItemId: Int? = null // non-null when isFollowing is true, null otherwise

    @Expose
    @SerializedName("type")
    var type: String? = null

    @Expose
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
