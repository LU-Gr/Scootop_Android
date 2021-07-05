package fr.scootop.data.model.user.domain

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.Poste
import fr.scootop.data.model.tools.Team

class SearchPlayer() : Parcelable{
    var name: String? = null
    var postes: List<Poste>? = null
    var team: Team? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchPlayer> {
        override fun createFromParcel(parcel: Parcel): SearchPlayer {
            return SearchPlayer(parcel)
        }

        override fun newArray(size: Int): Array<SearchPlayer?> {
            return arrayOfNulls(size)
        }
    }
}