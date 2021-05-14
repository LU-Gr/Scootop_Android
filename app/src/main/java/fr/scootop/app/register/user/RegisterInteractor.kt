package fr.scootop.app.register.user

import android.content.Context
import fr.scootop.BuildConfig
import fr.scootop.data.model.LoginResult
import fr.scootop.data.storage.TokenStorage
import fr.scootop.data.storage.UserStorage

open class RegisterInteractor(private val context: Context) {

    fun handle(loginResult: LoginResult, userEmail: String?) {
        TokenStorage.get(context).jwt = loginResult.jwt
        TokenStorage.get(context).refreshToken = loginResult.refreshToken
        UserStorage.get(context).user = loginResult.data.user

        if (!BuildConfig.DEBUG) {
        }
    }
}