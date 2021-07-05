package fr.scootop.data.model.configuration

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.user.domain.Player

class Poste() : Parcelable {
    val id: Long? = null
    val name: String = ""
    val players: List<Player>? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun toString(): String {
        return name
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Poste> {
        override fun createFromParcel(parcel: Parcel): Poste {
            return Poste(parcel)
        }

        override fun newArray(size: Int): Array<Poste?> {
            return arrayOfNulls(size)
        }
    }


}