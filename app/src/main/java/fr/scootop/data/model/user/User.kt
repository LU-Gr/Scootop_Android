package fr.scootop.data.model.user

import java.time.LocalDate

class User {
    var shortlistItemId: Int = 0//TEMP
    var isFollowing: Boolean = false//TEMP
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var birthday: LocalDate? = null
    var password: String? = null
    var contact: Contact? = null
    var userTypes: List<UserType>? = null


    fun userTypesToStringList(): List<String> {
        var types = mutableListOf<String>()
        for(type in userTypes!!){
            types.add(type.type!!)
        }
        return types
    }
}

