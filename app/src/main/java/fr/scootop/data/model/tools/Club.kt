package fr.scootop.data.model.tools

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.user.Contact
import fr.scootop.data.model.user.domain.Scoot

class Club(): Parcelable {
    var id: Long? = null
    var colorInside: String? = null
    var colorOutSide: String? = null
    var photoUrl: String? = null
    var name: String? = ""
    var contact: Contact? = null
    var teams: List<Team>? = null
    var scoots: List<Scoot>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        colorInside = parcel.readString()
        photoUrl = parcel.readString()
        colorOutSide = parcel.readString()
        name = parcel.readString()
        contact = parcel.readParcelable(Contact::class.java.classLoader)
        teams = parcel.createTypedArrayList(Team)
        scoots = parcel.createTypedArrayList(Scoot.CREATOR)
    }

    override fun toString(): String {
        return name!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(colorInside)
        parcel.writeString(colorOutSide)
        parcel.writeString(name)
        parcel.writeString(photoUrl)
        parcel.writeParcelable(contact, flags)
        parcel.writeTypedList(teams)
        parcel.writeTypedList(scoots)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Club> {
        override fun createFromParcel(parcel: Parcel): Club {
            return Club(parcel)
        }

        override fun newArray(size: Int): Array<Club?> {
            return arrayOfNulls(size)
        }
    }

}