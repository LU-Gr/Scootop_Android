package fr.scootop.data.model.statistics

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.tools.Match
import fr.scootop.data.model.user.domain.Player
import java.time.LocalDate

class Goal() : Parcelable {
    var id: Long? = null
    var date: LocalDate? = null
    var rating: Int? = null
    var shoot: Shoot? = null
    var match: Match? = null
    var player: Player? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        rating = parcel.readValue(Int::class.java.classLoader) as? Int
        shoot = parcel.readParcelable(Shoot::class.java.classLoader)
        match = parcel.readParcelable(Match::class.java.classLoader)
        player = parcel.readParcelable(Player::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(rating)
        parcel.writeParcelable(shoot, flags)
        parcel.writeParcelable(match, flags)
        parcel.writeParcelable(player, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Goal> {
        override fun createFromParcel(parcel: Parcel): Goal {
            return Goal(parcel)
        }

        override fun newArray(size: Int): Array<Goal?> {
            return arrayOfNulls(size)
        }
    }
}