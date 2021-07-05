package fr.scootop.data.model.services

import android.os.Parcelable
import fr.scootop.data.model.services.tools.video.Video
import fr.scootop.data.model.tools.Competition
import fr.scootop.data.model.tools.Saison
import fr.scootop.data.model.tools.Team
import fr.scootop.data.model.user.domain.Scoot
import fr.scootop.data.model.user.provider.Analyste
import fr.scootop.data.model.user.provider.Cameraman
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class Event (
    var id: Long? = null,
    var date: LocalDate? = null,
    var status: Boolean = false,
    var prestaWearable: Boolean = false,
    var prestaZoom: Boolean = false,
    var videos: List<Video>? = null,
    var competition: Competition? = null,
    var saison: Saison? = null,
    var teams: List<Team>? = null,
    var scoots: List<Scoot>? = null,
    var analysts: List<Analyste>? = null,
    var cameramans: List<Cameraman>? = null
): Parcelable