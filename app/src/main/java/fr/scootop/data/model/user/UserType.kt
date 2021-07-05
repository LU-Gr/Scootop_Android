package fr.scootop.data.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserType (
    val id: Long? = null,
    val type: String? = null,
    val users: List<User>? = null
): Parcelable