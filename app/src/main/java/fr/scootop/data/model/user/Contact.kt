package fr.scootop.data.model.user

class Contact {
    var id: Long? = null
    var tel: String? = null
    var address: String? = null
    var codePostal: String? = null
    var ville: String? = null
    var pays: String? = null
    override fun toString(): String {
        return "Contact(id=$id, tel=$tel, address=$address, codePostal=$codePostal, ville=$ville, pays=$pays)"
    }
}