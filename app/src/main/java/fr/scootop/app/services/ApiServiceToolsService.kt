package fr.scootop.app.services

import fr.scootop.data.model.services.tools.AgenceType
import fr.scootop.data.model.services.tools.PrestationType
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceToolsService {

    // AGENCE TYPE

    @Headers("Content-Type: application/json")
    @GET("/services/tools/agence/types")
    fun getAgenceTypes(): Call<List<AgenceType>>

    @Headers("Content-Type: application/json")
    @GET("/services/tools/agence/type/{id}")
    fun getAgenceTypeById(@Path("id") id: Long): Call<AgenceType>

    @Headers("Content-Type: application/json")
    @POST("/services/tools/agence/type")
    fun addAgenceType(@Body agenceType: AgenceType): Call<AgenceType>

    @Headers("Content-Type: application/json")
    @PUT("/services/tools/agence/type/{id}")
    fun updateAgenceType(@Path("id") id: Long, @Body agenceType: AgenceType): Call<AgenceType>

    @Headers("Content-Type: application/json")
    @DELETE("/services/tools/agence/type/{id}")
    fun deleteAgenceType(@Path("id") id: Long): Call<String>

    //PRESTATION TYPE

    @Headers("Content-Type: application/json")
    @GET("/services/tools/prestations")
    fun getPrestationsType(): Call<List<PrestationType>>

    @Headers("Content-Type: application/json")
    @GET("/services/tools/prestation/{id}")
    fun getPrestationTypeById(@Path("id") id: Long): Call<PrestationType>

    @Headers("Content-Type: application/json")
    @POST("/services/tools/prestation")
    fun addPrestationType(@Body prestationType: PrestationType): Call<PrestationType>

    @Headers("Content-Type: application/json")
    @PUT("/services/tools/prestation/{id}")
    fun updatePrestationType(@Path("id") id: Long, @Body prestationType: PrestationType): Call<PrestationType>

    @Headers("Content-Type: application/json")
    @DELETE("/services/tools/prestation/{id}")
    fun deletePrestationType(@Path("id") id: Long): Call<String>
}