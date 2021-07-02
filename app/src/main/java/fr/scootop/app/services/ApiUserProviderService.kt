package fr.scootop.app.services

import fr.scootop.data.model.user.provider.*
import retrofit2.http.Headers
import retrofit2.Call
import retrofit2.http.*

interface ApiUserProviderService {

    // CAMERAMAN

    @Headers("Content-Type: application/json")
    @GET("/user/provider/cameramans")
    fun getCameramen(): Call<List<Cameraman>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/cameraman/{id}")
    fun getCameramanById(@Path("id") id: Long): Call<Cameraman>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/cameraman")
    fun addCameraman(@Body cameraman: Cameraman): Call<Cameraman>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/cameraman/{id}")
    fun updateCameraman(@Path("id") id: Long, @Body cameraman: Cameraman): Call<Cameraman>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/cameraman/{id}")
    fun deleteCameraman(@Path("id") id: Long): Call<String>

    // AGENCE

    @Headers("Content-Type: application/json")
    @GET("/user/provider/agences")
    fun getAgences(): Call<List<Agence>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/agence/{id}")
    fun getAgenceById(@Path("id") id: Long): Call<Agence>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/agence")
    fun addAgence(@Body agence: Agence): Call<Agence>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/agence/{id}")
    fun updateAgence(@Path("id") id: Long, @Body agence: Agence): Call<Agence>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/agence/{id}")
    fun deleteAgence(@Path("id") id: Long): Call<String>

    // ANALYST

    @Headers("Content-Type: application/json")
    @GET("/user/provider/analysts")
    fun getAnalysts(): Call<List<Analyste>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/analyst/{id}")
    fun getAnalystById(@Path("id") id: Long): Call<Analyste>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/analyst")
    fun addAnalyst(@Body analyste: Analyste): Call<Analyste>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/analyst/{id}")
    fun updateAnalyst(@Path("id") id: Long, @Body analyste: Analyste): Call<Analyste>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/analyst/{id}")
    fun deleteAnalyst(@Path("id") id: Long): Call<String>

    // MANAGER

    @Headers("Content-Type: application/json")
    @GET("/user/provider/managers")
    fun getManagers(): Call<List<Manager>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/manager/{id}")
    fun getManagerById(): Call<Manager>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/manager")
    fun addManager(@Body manager: Manager): Call<Manager>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/manager/{id}")
    fun updateManager(@Path("id") id: Long, @Body manager: Manager): Call<Manager>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/manager/{id}")
    fun deleteManager(@Path("id") id: Long): Call<String>

    // MARKETING ADVISOR

    @Headers("Content-Type: application/json")
    @GET("/user/provider/marketing/advisors")
    fun getMarketingAdvisors(): Call<List<MarketingAdvisor>>

    @Headers("Content-Type: application/json")
    @GET("/user/provider/marketing/advisor/{id}")
    fun getMarketingAdvisorById(@Path("id") id: Long): Call<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @POST("/user/provider/marketing/advisor")
    fun addMarketingAdvisor(@Body marketingAdvisor: MarketingAdvisor): Call<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @PUT("/user/provider/marketing/advisor/{id}")
    fun updateMarketingAdvisor(@Path("id") id: Long, @Body marketingAdvisor: MarketingAdvisor): Call<MarketingAdvisor>

    @Headers("Content-Type: application/json")
    @DELETE("/user/provider/marketing/advisor/{id}")
    fun deleteMarketingAdvisor(@Path("id") id: Long): Call<String>
}