package fr.scootop.data.model.user.domain

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.services.Shortlist
import fr.scootop.data.model.tools.Club
import fr.scootop.data.model.user.User


class Scoot(): Parcelable {
    private val id: Long? = null
    private val user: User? = null
    private val shortlist: Shortlist? = null
    private val clubs: List<Club>? = null
    private val followedShortlists: List<Shortlist>? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Scoot> {
        override fun createFromParcel(parcel: Parcel): Scoot {
            return Scoot(parcel)
        }

        override fun newArray(size: Int): Array<Scoot?> {
            return arrayOfNulls(size)
        }
    }
}