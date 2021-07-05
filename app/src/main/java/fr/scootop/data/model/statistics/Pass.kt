package fr.scootop.data.model.statistics

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.TouchType
import fr.scootop.data.model.tools.Match
import fr.scootop.data.model.user.domain.Player


class Pass(): Parcelable {
    var id: Long? = null
    var minute: Int = 0
    var decisive: Boolean? = null
    var isSuccess: Boolean? = null
    var isLongPass: Boolean? = null
    var player: Player? = null
    var match: Match? = null
    var touchType: TouchType? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        minute = parcel.readInt()
        decisive = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isSuccess = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isLongPass = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        player = parcel.readParcelable(Player::class.java.classLoader)
        match = parcel.readParcelable(Match::class.java.classLoader)
        touchType = parcel.readParcelable(TouchType::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(minute)
        parcel.writeValue(decisive)
        parcel.writeValue(isSuccess)
        parcel.writeValue(isLongPass)
        parcel.writeParcelable(player, flags)
        parcel.writeParcelable(match, flags)
        parcel.writeParcelable(touchType, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pass> {
        override fun createFromParcel(parcel: Parcel): Pass {
            return Pass(parcel)
        }

        override fun newArray(size: Int): Array<Pass?> {
            return arrayOfNulls(size)
        }
    }
}