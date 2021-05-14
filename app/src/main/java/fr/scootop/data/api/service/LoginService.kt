package fr.scootop.data.api.service

import fr.scootop.data.model.LoginResult
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

interface LoginService {

    @FormUrlEncoded
    @POST("api/login_check")
    fun login(@Field("_username") username: String, @Field("_password") password: String): Observable<LoginResult>

    @FormUrlEncoded
    @POST("api/token/refresh")
    fun refreshToken(@Field("refresh_token") refreshToken: String): Call<LoginResult>
}
