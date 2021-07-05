package fr.scootop.data.model.user.domain

import android.os.Parcel
import android.os.Parcelable

class PlayerSearchResult(): Parcelable {
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null
    var photoUrl: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        firstName = parcel.readValue(String::class.java.classLoader) as? String
        lastName = parcel.readValue(String::class.java.classLoader) as? String
        photoUrl = parcel.readValue(String::class.java.classLoader) as? String
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(firstName)
        parcel.writeValue(lastName)
        parcel.writeValue(photoUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlayerSearchResult> {
        override fun createFromParcel(parcel: Parcel): PlayerSearchResult {
            return PlayerSearchResult(parcel)
        }

        override fun newArray(size: Int): Array<PlayerSearchResult?> {
            return arrayOfNulls(size)
        }
    }
}