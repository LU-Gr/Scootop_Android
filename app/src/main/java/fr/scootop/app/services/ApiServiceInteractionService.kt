package fr.scootop.app.services

import fr.scootop.data.model.services.interaction.Alert
import fr.scootop.data.model.services.interaction.Follow
import fr.scootop.data.model.services.interaction.Invite
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiServiceInteractionService {

    // ALERT

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/alerts")
    fun getAlerts(): Response<List<Alert>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/alert/{id}")
    fun getAlertById(@Path("id") id: Integer): Response<Alert>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/alert")
    fun addAlert(@Body alert: Alert): Response<Alert>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/alert/{id}")
    fun updateAlert(@Path("id") id: Integer, @Body alert: Alert): Response<Alert>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction")
    fun deleteAlert(@Path("id") id: Integer): Response<String>

    // FOLLOW

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/follows")
    fun getFollows(): Response<List<Follow>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/follow/{id}")
    fun getFollowById(@Path("id") id: Integer): Response<Follow>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/follow")
    fun addFollow(@Body follow: Follow): Response<Follow>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/follow/{id}")
    fun updateFollow(@Path("id") id: Integer, @Body follow: Follow): Response<Follow>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction/follow/{id}")
    fun deleteFollow(@Path("id") id: Integer): Response<String>

    // INVITE

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/invites")
    fun getInvites(): Response<List<Invite>>

    @Headers("Content-Type: application/json")
    @GET("/services/interaction/invite/{id}")
    fun getInviteById(@Path("id") id: Integer): Response<Invite>

    @Headers("Content-Type: application/json")
    @POST("/services/interaction/invite")
    fun addInvite(@Body invite: Invite): Response<Invite>

    @Headers("Content-Type: application/json")
    @PUT("/services/interaction/invite/{id}")
    fun updateInvite(@Path("id") id: Integer, @Body invite: Invite): Response<Invite>

    @Headers("Content-Type: application/json")
    @DELETE("/services/interaction/invite/{id}")
    fun deleteInvite(@Path("id") id: Integer): Response<String>

}