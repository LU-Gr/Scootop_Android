package fr.scootop.data.model.user

import java.time.LocalDate

class User {
    val id: Long? = null
    val firstName: String? = null
    val lastName: String? = null
    val email: String? = null
    val birthday: LocalDate? = null
    val password: String? = null
    val contact: Contact? = null
    val userTypes: List<UserType>? = null
}