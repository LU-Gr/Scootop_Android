package fr.scootop.data.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact (
    var id: Long? = null,
    var tel: String? = null,
    var address: String? = null,
    var codePostal: String? = null,
    var ville: String? = null,
    var pays: String? = null
): Parcelable