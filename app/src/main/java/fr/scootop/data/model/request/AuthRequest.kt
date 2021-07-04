package fr.scootop.data.model.request

import com.google.gson.annotations.Expose

class AuthRequest {

    @Expose
    var email: String = ""

    @Expose
    var password: String = ""


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AuthRequest

        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }

    override fun toString(): String {
        return "AuthRequest(email='$email', password='$password')"
    }
}


