package fr.scootop.app.services

import fr.scootop.data.model.response.ApiResult
import fr.scootop.data.model.services.interaction.Alert
import fr.scootop.data.model.services.interaction.Follow
import fr.scootop.data.model.services.interaction.Invite
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

interface ApiServiceInteractionService {

    // ALERT

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/alerts")
    fun getAlerts(): Call<List<Alert>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/alert/{id}")
    fun getAlertById(@Path("id") id: Long): Call<Alert>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/alert")
    fun addAlert(@Body alert: Alert): Call<Alert>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/alert/{id}")
    fun updateAlert(@Path("id") id: Long, @Body alert: Alert): Call<Alert>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction")
    fun deleteAlert(@Path("id") id: Long): Call<String>

    // FOLLOW

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/follows")
    fun getFollows(): Call<List<Follow>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/follow/{id}")
    fun getFollowById(@Path("id") id: Long): Call<Follow>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/follow")
    fun addFollow(@Body follow: Follow): Call<Follow>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/follow/{id}")
    fun updateFollow(@Path("id") id: Long, @Body follow: Follow): Call<Follow>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction/follow/{id}")
    fun deleteFollow(@Path("id") id: Long): Call<String>

    // INVITE

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/invites")
    fun getInvites(): Call<List<Invite>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/invite/{id}")
    fun getInviteById(@Path("id") id: Long): Call<Invite>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/invite")
    fun addInvite(@Body invite: Invite): Observable<ApiResult>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/invite/{id}")
    fun updateInvite(@Path("id") id: Long, @Body invite: Invite): Call<Invite>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction/invite/{id}")
    fun deleteInvite(@Path("id") id: Long): Call<String>

}