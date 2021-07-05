package fr.scootop.data.model.tools

import android.os.Parcel
import android.os.Parcelable
import fr.scootop.data.model.services.Event
import fr.scootop.data.model.statistics.Action
import fr.scootop.data.model.statistics.Goal
import fr.scootop.data.model.statistics.Pass
import fr.scootop.data.model.statistics.Shoot
import fr.scootop.data.model.user.domain.Player

class StatisticalSheet(): Parcelable {
    var id: Long? = null
    var nbBallplayed: Int = 0
    var nbBalllost: Int = 0
    var nbBallSuccess: Int = 0
    var distancekm: Float = 0f
    var match: Match? = null
    var event: Event? = null
    var player: Player? = null
    var team: Team? = null
    var Shoots: List<Shoot>? = null
    var passes: List<Pass>? = null
    var actions: List<Action>? = null
    var goals: List<Goal>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        nbBallplayed = parcel.readInt()
        nbBalllost = parcel.readInt()
        nbBallSuccess = parcel.readInt()
        distancekm = parcel.readFloat()
        match = parcel.readParcelable(Match::class.java.classLoader)
        event = parcel.readParcelable(Event::class.java.classLoader)
        player = parcel.readParcelable(Player::class.java.classLoader)
        team = parcel.readParcelable(Team::class.java.classLoader)
        Shoots = parcel.createTypedArrayList(Shoot.CREATOR)
        passes = parcel.createTypedArrayList(Pass.CREATOR)
        actions = parcel.createTypedArrayList(Action.CREATOR)
        goals = parcel.createTypedArrayList(Goal.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(nbBallplayed)
        parcel.writeInt(nbBalllost)
        parcel.writeInt(nbBallSuccess)
        parcel.writeFloat(distancekm)
        parcel.writeParcelable(match, flags)
        parcel.writeParcelable(event, flags)
        parcel.writeParcelable(player, flags)
        parcel.writeParcelable(team, flags)
        parcel.writeTypedList(Shoots)
        parcel.writeTypedList(passes)
        parcel.writeTypedList(actions)
        parcel.writeTypedList(goals)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StatisticalSheet> {
        override fun createFromParcel(parcel: Parcel): StatisticalSheet {
            return StatisticalSheet(parcel)
        }

        override fun newArray(size: Int): Array<StatisticalSheet?> {
            return arrayOfNulls(size)
        }
    }
}