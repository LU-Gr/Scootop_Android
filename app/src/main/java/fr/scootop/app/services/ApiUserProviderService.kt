package fr.scootop.app.services

import fr.scootop.data.model.user.provider.*
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiUserProviderService {

    // CAMERAMAN

    @Headers("Content-Type: application/json")
    @GET("/user/provider/cameramans")
    fun getCameramen(): Response<List<Cameraman>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/cameraman/{id}")
    fun getCameramanById(@Path("id") id: Integer): Response<Cameraman>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/cameraman")
    fun addCameraman(@Body cameraman: Cameraman): Response<Cameraman>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/cameraman/{id}")
    fun updateCameraman(@Path("id") id: Integer, @Body cameraman: Cameraman): Response<Cameraman>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/cameraman/{id}")
    fun deleteCameraman(@Path("id") id: Integer): Response<String>

    // AGENCE

    @Headers("Content-Type: application/json")
    @GET("/user/provider/agences")
    fun getAgences(): Response<List<Agence>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/agence/{id}")
    fun getAgenceById(@Path("id") id: Integer): Response<Agence>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/agence")
    fun addAgence(@Body agence: Agence): Response<Agence>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/agence/{id}")
    fun updateAgence(@Path("id") id: Integer, @Body agence: Agence): Response<Agence>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/agence/{id}")
    fun deleteAgence(@Path("id") id: Integer): Response<String>

    // ANALYST

    @Headers("Content-Type: application/json")
    @GET("/user/provider/analysts")
    fun getAnalysts(): Response<List<Analyste>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/analyst/{id}")
    fun getAnalystById(@Path("id") id: Integer): Response<Analyste>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/analyst")
    fun addAnalyst(@Body analyste: Analyste): Response<Analyste>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/analyst/{id}")
    fun updateAnalyst(@Path("id") id: Integer, @Body analyste: Analyste): Response<Analyste>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/analyst/{id}")
    fun deleteAnalyst(@Path("id") id: Integer): Response<String>

    // MANAGER

    @Headers("Content-Type: application/json")
    @GET("/user/provider/managers")
    fun getManagers(): Response<List<Manager>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/manager/{id}")
    fun getManagerById(): Response<Manager>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/manager")
    fun addManager(@Body manager: Manager): Response<Manager>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/manager/{id}")
    fun updateManager(@Path("id") id: Integer, @Body manager: Manager): Response<Manager>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/manager/{id}")
    fun deleteManager(@Path("id") id: Integer): Response<String>

    // MARKETING ADVISOR

    @Headers("Content-Type: application/json")
    @GET("/user/provider/marketing/advisors")
    fun getMarketingAdvisors(): Response<List<MarketingAdvisor>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/marketing/advisor/{id}")
    fun getMarketingAdvisorById(@Path("id") id: Integer): Response<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/marketing/advisor")
    fun addMarketingAdvisor(@Body marketingAdvisor: MarketingAdvisor): Response<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/marketing/advisor/{id}")
    fun updateMarketingAdvisor(@Path("id") id: Integer, @Body marketingAdvisor: MarketingAdvisor): Response<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/marketing/advisor/{id}")
    fun deleteMarketingAdvisor(@Path("id") id: Integer): Response<String>
}