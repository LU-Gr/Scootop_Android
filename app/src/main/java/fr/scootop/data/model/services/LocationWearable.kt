package fr.scootop.data.model.services

import android.os.Parcelable
import fr.scootop.data.model.tools.Match
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.domain.Player
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationWearable (
    var id: Long? = null,
    var player: Player? = null,
    var team: Team? = null,
    var match: Match? = null,
    var distanceRun: Int? = null,
    var distancePlay: Int? = null,
    var vMax: Int? = null,
    var vMaxWithBall: Int? = null,
    var ballPlay: Int? = null,
    var looseBall: Int? = null,
    var ballRecovered: Int? = null,
    var tackle: Int? = null,
    var foulSuffered: Int? = null,
    var failPass: Int? = null,
    var assist: Int? = null,
    var shortPass: Int? = null,
    var head: Int? = null,
    var headOffensive: Int? = null,
    var headDefensive: Int? = null,
    var shots: Int? = null,
    var shotOnTarget: Int? = null,
    var shotOffTarget: Int? = null,
    var longShot: Int? = null,
    var successSkill: Int? = null,
    var failSkill: Int? = null
) : Parcelable