package fr.scootop.data.api.service

import fr.scootop.data.model.LoginResult
import fr.scootop.data.model.request.RegisterUserObserver
import fr.scootop.data.model.request.RegisterUserPlayer
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface RegisterService {

    @POST("api/register")
    fun register(@Body registerObserver: RegisterUserObserver): Observable<LoginResult>

    @POST("api/register")
    fun register(@Body registerUserPlayer: RegisterUserPlayer): Observable<LoginResult>
}
