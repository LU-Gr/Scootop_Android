package fr.scootop.data.model.tools

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.PlayerSearchItem.CREATOR
import fr.scootop.data.model.configuration.Category
import fr.scootop.data.model.configuration.CompetitionType
import fr.scootop.data.model.user.domain.Coach
import fr.scootop.data.model.user.domain.Player

class Team(): Parcelable {
    var id: Long? = null
    var name: String? = ""
    var club: Club? = null
    var competitionType: CompetitionType? = null
    var category: Category? = null
    var coaches: List<Coach>? = null
    var players: List<Player>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        name = parcel.readString()
        category = parcel.readParcelable(Category::class.java.classLoader)
        players = parcel.createTypedArrayList(Player.CREATOR)
    }

    override fun toString(): String {
        return name!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeParcelable(category, flags)
        parcel.writeTypedList(players)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Team> {
        override fun createFromParcel(parcel: Parcel): Team {
            return Team(parcel)
        }

        override fun newArray(size: Int): Array<Team?> {
            return arrayOfNulls(size)
        }
    }
}