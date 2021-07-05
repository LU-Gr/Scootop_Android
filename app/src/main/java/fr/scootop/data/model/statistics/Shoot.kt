package fr.scootop.data.model.statistics

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.TouchType
import fr.scootop.data.model.tools.Match
import fr.scootop.data.model.user.domain.Player


class Shoot(): Parcelable{
    var id: Long? = null
    var minute: Int = 0
    var isFreeKick: Boolean? = null
    var isPenaltyBox: Boolean? = null
    var isGoal: Boolean? = null
    var isLongShoot: Boolean? = null
    var isInBox: Boolean? = null
    var pass: Pass? = null
    var match: Match? = null
    var touchType: TouchType? = null
    var player: Player? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        minute = parcel.readInt()
        isFreeKick = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isPenaltyBox = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isGoal = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isLongShoot = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isInBox = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        pass = parcel.readParcelable(Pass::class.java.classLoader)
        match = parcel.readParcelable(Match::class.java.classLoader)
        touchType = parcel.readParcelable(TouchType::class.java.classLoader)
        player = parcel.readParcelable(Player::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(minute)
        parcel.writeValue(isFreeKick)
        parcel.writeValue(isPenaltyBox)
        parcel.writeValue(isGoal)
        parcel.writeValue(isLongShoot)
        parcel.writeValue(isInBox)
        parcel.writeParcelable(pass, flags)
        parcel.writeParcelable(match, flags)
        parcel.writeParcelable(touchType, flags)
        parcel.writeParcelable(player, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shoot> {
        override fun createFromParcel(parcel: Parcel): Shoot {
            return Shoot(parcel)
        }

        override fun newArray(size: Int): Array<Shoot?> {
            return arrayOfNulls(size)
        }
    }
}