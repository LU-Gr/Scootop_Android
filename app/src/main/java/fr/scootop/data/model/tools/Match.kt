package fr.scootop.data.model.tools

import android.os.Parcelable
import fr.scootop.data.model.configuration.Stade
import fr.scootop.data.model.services.Event
import fr.scootop.data.model.services.LocationWearable
import fr.scootop.data.model.user.domain.Scoot
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Match (
    var id: Long? = null,
    var event: Event? = null,
    var competition: Competition? = null,
    var teamA: Team? = null,
    var teamB: Team? = null,
    var stade: Stade? = null,
    var saison: Saison? = null,
    var statisticalSheetsTeamB: List<StatisticalSheet>? = null,
    var statisticalSheetsTeamA: List<StatisticalSheet>? = null,
    var wearables: List<LocationWearable>? = null,
    var scoots: List<Scoot>? = null
): Parcelable