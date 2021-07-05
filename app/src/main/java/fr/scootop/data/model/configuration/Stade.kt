package fr.scootop.data.model.configuration

import android.os.Parcelable
import fr.scootop.data.model.user.Contact
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stade (
    private val id: Long? = null,
    private val name: String? = null,
    private val contact: Contact? = null
) : Parcelable