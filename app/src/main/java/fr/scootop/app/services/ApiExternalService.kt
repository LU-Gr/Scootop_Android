package fr.scootop.app.services

import fr.scootop.data.model.services.*
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*
interface ApiExternalService {

    //EVENT

    @Headers("Content-Type: application/json")
    @GET("/services/events")
    fun getEvents(): Response<List<Event>>

    @Headers("Content-Type: application/json")
    @GET("/services/event/{id}")
    fun getEventById(@Path("id") id: Integer): Response<Event>

    @Headers("Content-Type: application/json")
    @POST("/services/event")
    fun addEvent(@Body event: Event): Response<Event>

    @Headers("Content-Type: application/json")
    @PUT("/services/event/{id}")
    fun updateEvent(@Path("id") id: Integer, @Body event: Event): Response<Event>

    @Headers("Content-Type: application/json")
    @DELETE("/services/event/{id}")
    fun deleteEvent(@Path("id") id: Integer): Response<String>

    // SHORTLIST

    @Headers("Content-Type: application/json")
    @GET("/services/shortlists")
    fun getShortlists(): Response<List<Shortlist>>

    @Headers("Content-Type: application/json")
    @GET("/services/shortlist/{id}")
    fun getShortlistById(@Path("id") id: Integer): Response<Shortlist>

    @Headers("Content-Type: application/json")
    @POST("/services/shortlist")
    fun addShortlist(@Body shortlist: Shortlist): Response<Shortlist>

    @Headers("Content-Type: application/json")
    @PUT("/services/shortlist/{id}")
    fun updateShortlist(@Path("id") id: Integer, @Body shortlist: Shortlist): Response<Shortlist>

    @Headers("Content-Type: application/json")
    @DELETE("/services/shortlist/{id}")
    fun deleteShortlist(@Path("id") id: Integer): Response<String>

    // LOCATION WEARABLE

    @Headers("Content-Type: application/json")
    @GET("/services/match/wearables")
    fun getMatchWearables(): Response<List<LocationWearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/match/wearable/{id}")
    fun getMatchWearableById(@Path("id") id: Integer): Response<LocationWearable>

    @Headers("Content-Type: application/json")
    @POST("/services/match/wearable")
    fun addMatchWearable(@Body locationWearable: LocationWearable): Response<LocationWearable>

    @Headers("Content-Type: application/json")
    @PUT("/services/match/wearable/{id}")
    fun updateMatchWearable(@Path("id") id: Integer, @Body locationWearable: LocationWearable): Response<LocationWearable>

    @Headers("Content-Type: application/json")
    @DELETE("/services/match/wearable/{id}")
    fun deleteMatchWearable(@Path("id") id: Integer): Response<String>

    @Headers("Content-Type: application/json")
    @GET("/services/match/{matchId}/team/{teamId}/wearables")
    fun getWearablesByMatchAndTeam(@Path("matchId") matchId: Integer, @Path("teamId") teamId: Integer): Response<List<LocationWearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/match/{matchId}/team/{teamId}/wearables/{playerId}")
    fun getPlayerWearableByMatchAndTeam(@Path("matchId") matchId: Integer, @Path("teamId") teamId: Integer, @Path("playerId") playerId: Integer): Response<LocationWearable>

    // WEARABLE COMPANY

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/companies")
    fun getWearableCompanies(): Response<List<WearableCompany>>

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/company/{id}")
    fun getWearableCompanyById(@Path("id") id: Integer): Response<WearableCompany>

    @Headers("Content-Type: application/json")
    @POST("/services/wearable/company")
    fun addWearableCompany(@Body wearableCompany: WearableCompany): Response<WearableCompany>

    @Headers("Content-Type: application/json")
    @PUT("/services/wearable/company/{id}")
    fun updateWearableCompany(@Path("id") id: Integer, @Body wearableCompany: WearableCompany): Response<WearableCompany>

    @Headers("Content-Type: application/json")
    @DELETE("/services/wearable/company/{id}")
    fun deleteWearableCompany(@Path("id") id: Integer): Response<String>

    // WEARABLE

    @Headers("Content-Type: application/json")
    @GET("/services/wearables")
    fun getWearables(): Response<List<Wearable>>

    @Headers("Content-Type: application/json")
    @GET("/services/wearable/{id}")
    fun getWearableById(@Path("id") id: Integer): Response<Wearable>

    @Headers("Content-Type: application/json")
    @POST("/services/wearable")
    fun addWearable(@Body wearable: Wearable): Response<Wearable>

    @Headers("Content-Type: application/json")
    @PUT("/services/wearable/{id}")
    fun updateWearable(@Path("id") id: Integer, @Body wearable: Wearable): Response<Wearable>

    @Headers("Content-Type: application/json")
    @DELETE("/services/wearable/{id}")
    fun deleteWearable(@Path("id") id: Integer): Response<String>


}