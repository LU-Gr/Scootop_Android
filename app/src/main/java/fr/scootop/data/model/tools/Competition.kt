package fr.scootop.data.model.tools

import android.os.Parcelable
import fr.scootop.data.model.configuration.CompetitionType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Competition (
    var id: Long? = null,
    var name: String? = null,
    var playerMax: Int = 0,
    var playerMin: Int = 0,
    var nbTitulaire: Int = 0,
    var nbRemplacant: Int = 0,
    var nbSubstition: Int = 0,
    var dureeMiTemps: Int = 0,
    var competitionType: CompetitionType? = null
): Parcelable