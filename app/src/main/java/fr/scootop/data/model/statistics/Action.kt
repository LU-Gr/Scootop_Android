package fr.scootop.data.model.statistics

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.configuration.ActionType
import fr.scootop.data.model.tools.Match
import fr.scootop.data.model.user.domain.Player

class Action(): Parcelable {
    var id: Long? = null
    var minute: Int = 0
    var isDefensive: Boolean? = null
    var isSuccessful: Boolean? = null
    var actionType: ActionType? = null
    var match: Match? = null
    var player: Player? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        minute = parcel.readInt()
        isDefensive = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isSuccessful = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        actionType = parcel.readParcelable(ActionType::class.java.classLoader)
        match = parcel.readParcelable(Match::class.java.classLoader)
        player = parcel.readParcelable(Player::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(minute)
        parcel.writeValue(isDefensive)
        parcel.writeValue(isSuccessful)
        parcel.writeParcelable(actionType, flags)
        parcel.writeParcelable(match, flags)
        parcel.writeParcelable(player, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Action> {
        override fun createFromParcel(parcel: Parcel): Action {
            return Action(parcel)
        }

        override fun newArray(size: Int): Array<Action?> {
            return arrayOfNulls(size)
        }
    }
}