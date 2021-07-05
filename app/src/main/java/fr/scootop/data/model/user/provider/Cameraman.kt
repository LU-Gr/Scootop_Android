package fr.scootop.data.model.user.provider

import android.os.Parcelable
import fr.scootop.data.model.user.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cameraman (
    private val id: Long? = null,
    private val tarif: Double? = null,
    private val experience: Int? = null,
    private val user: User? = null
) : Parcelable