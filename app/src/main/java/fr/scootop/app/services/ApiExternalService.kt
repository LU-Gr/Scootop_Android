package fr.scootop.app.services

import fr.scootop.data.model.services.*
import retrofit2.Call
import retrofit2.http.*
interface ApiExternalService {

    //EVENT

    @Headers("Content-Type: application/json")
    @GET("/services/events")
    fun getEvents(): Call<List<Event>>

    @Headers("Content-Type: application/json")
    @GET("/services/event/{id}")
    fun getEventById(@Path("id") id: Long): Call<Event>

    @Headers("Content-Type: application/json")
    @POST("/services/event")
    fun addEvent(@Body event: Event): Call<Event>

    @Headers("Content-Type: application/json")
    @PUT("/services/event/{id}")
    fun updateEvent(@Path("id") id: Long, @Body event: Event): Call<Event>

    @Headers("Content-Type: application/json")
    @DELETE("/services/event/{id}")
    fun deleteEvent(@Path("id") id: Long): Call<String>

    // SHORTLIST

    @Headers("Content-Type: application/json")
    @GET("/services/shortlists")
    fun getShortlists(): Call<List<Shortlist>>

    @Headers("Content-Type: application/json")
    @GET("/services/shortlist/{id}")
    fun getShortlistById(@Path("id") id: Long): Call<Shortlist>

    @Headers("Content-Type: application/json")
    @POST("/services/shortlist")
    fun addShortlist(@Body shortlist: Shortlist): Call<Shortlist>

    @Headers("Content-Type: application/json")
    @PUT("/services/shortlist/{id}")
    fun updateShortlist(@Path("id") id: Long, @Body shortlist: Shortlist): Call<Shortlist>

    @Headers("Content-Type: application/json")
    @DELETE("/services/shortlist/{id}")
    fun deleteShortlist(@Path("id") id: Long): Call<String>

    // LOCATION WEARABLE

    @Headers("Content-Type: application/json")
    @GET("/services/match/wearables")
    fun getMatchWearables(): Call<List<LocationWearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/match/wearable/{id}")
    fun getMatchWearableById(@Path("id") id: Long): Call<LocationWearable>

    @Headers("Content-Type: application/json")
    @POST("/services/match/wearable")
    fun addMatchWearable(@Body locationWearable: LocationWearable): Call<LocationWearable>

    @Headers("Content-Type: application/json")
    @PUT("/services/match/wearable/{id}")
    fun updateMatchWearable(@Path("id") id: Long, @Body locationWearable: LocationWearable): Call<LocationWearable>

    @Headers("Content-Type: application/json")
    @DELETE("/services/match/wearable/{id}")
    fun deleteMatchWearable(@Path("id") id: Long): Call<String>

    @Headers("Content-Type: application/json")
    @GET("/services/match/{matchId}/team/{teamId}/wearables")
    fun getWearablesByMatchAndTeam(@Path("matchId") matchId: Long, @Path("teamId") teamId: Long): Call<List<LocationWearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/match/{matchId}/team/{teamId}/wearables/{playerId}")
    fun getPlayerWearableByMatchAndTeam(@Path("matchId") matchId: Long, @Path("teamId") teamId: Long, @Path("playerId") playerId: Long): Call<LocationWearable>

    // WEARABLE COMPANY

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/companies")
    fun getWearableCompanies(): Call<List<WearableCompany>>

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/company/{id}")
    fun getWearableCompanyById(@Path("id") id: Long): Call<WearableCompany>

    @Headers("Content-Type: application/json")
    @POST("/services/wearable/company")
    fun addWearableCompany(@Body wearableCompany: WearableCompany): Call<WearableCompany>

    @Headers("Content-Type: application/json")
    @PUT("/services/wearable/company/{id}")
    fun updateWearableCompany(@Path("id") id: Long, @Body wearableCompany: WearableCompany): Call<WearableCompany>

    @Headers("Content-Type: application/json")
    @DELETE("/services/wearable/company/{id}")
    fun deleteWearableCompany(@Path("id") id: Long): Call<String>

    // WEARABLE

    @Headers("Content-Type: application/json")
    @GET("/services/wearables")
    fun getWearables(): Call<List<Wearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/{id}")
    fun getWearableById(@Path("id") id: Long): Call<Wearable>

    @Headers("Content-Type: application/json")
    @POST("/services/wearable")
    fun addWearable(@Body wearable: Wearable): Call<Wearable>

    @Headers("Content-Type: application/json")
    @PUT("/services/wearable/{id}")
    fun updateWearable(@Path("id") id: Long, @Body wearable: Wearable): Call<Wearable>

    @Headers("Content-Type: application/json")
    @DELETE("/services/wearable/{id}")
    fun deleteWearable(@Path("id") id: Long): Call<String>


}