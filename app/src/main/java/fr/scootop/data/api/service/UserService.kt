package fr.scootop.data.api.service

import fr.scootop.data.model.Player
import fr.scootop.data.model.response.ApiResult
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

interface UserService {

    @GET("api/user_players/{id}.json")
    fun getPlayer(@Path("id") playerId: Int): Observable<Player>

    @POST("api/user_players/{id}/report")
    fun reportPlayer(@Path("id") playerId: Int): Observable<ApiResult>

    @POST("api/user_players/{id}/invite")
    fun invitePlayer(@Path("id") playerId: Int): Observable<ApiResult>
}
