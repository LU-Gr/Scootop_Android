package fr.scootop.data.model.configuration

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompetitionType (
    var id: Long? = null,
    var name: String? = null
) : Parcelable