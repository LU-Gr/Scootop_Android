package fr.scootop.data.api.authenticator

import android.text.TextUtils
import fr.scootop.app.ScootopApplication
import fr.scootop.data.api.ApiManager
import fr.scootop.data.storage.TokenStorage
import fr.scootop.data.storage.UserStorage
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException

class JWTAuthenticator : Authenticator {

    @Throws(IOException::class)
    override fun authenticate(route: Route, response: Response): Request? {

        val context = ScootopApplication.getContext()
        val refreshToken = TokenStorage.get(context).refreshToken ?: return null

        val loginResult = ApiManager.get().loginService
            .refreshToken(refreshToken)
            .execute()
            .body()

        if (loginResult.code == null && !TextUtils.isEmpty(loginResult.jwt)) {
            TokenStorage.get(context).jwt = loginResult.jwt
            TokenStorage.get(context).refreshToken = loginResult.refreshToken
            UserStorage.get(context).user = loginResult.user

            return response.request().newBuilder()
                .header("Authorization", "Bearer " + loginResult.jwt)
                .build()
        }

        return null
    }
    
}
