package fr.scootop.data.model.tools

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class Saison (
    var id: Int? = null,
    var dateDebut: LocalDate? = null,
    var dateFin: LocalDate? = null,
    var matchs: List<Match>? = null
) : Parcelable