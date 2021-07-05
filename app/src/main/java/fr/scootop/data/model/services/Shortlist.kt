package fr.scootop.data.model.services

import android.os.Parcelable
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.User
import fr.scootop.data.model.user.domain.Player
import fr.scootop.data.model.user.domain.Scoot
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shortlist (
    var id: Long? = null,
    var rank: Int = 0,
    var user: User? = null,
    var Players: List<Player>? = null,
    var Scoots: List<Scoot>? = null,
    var Teams: List<Team>? = null
): Parcelable