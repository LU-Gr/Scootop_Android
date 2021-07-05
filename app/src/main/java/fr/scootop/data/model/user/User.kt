package fr.scootop.data.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class User (
    var shortlistItemId: Int = 0,//TEMP,
    var isFollowing: Boolean = false,//TEMP,
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var birthday: LocalDate? = null,
    var password: String? = null,
    var contact: Contact? = null,
    var userTypes: List<UserType>? = null
): Parcelable

