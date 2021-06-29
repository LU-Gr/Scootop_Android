package fr.scootop.app.services

import fr.scootop.data.model.services.tools.AgenceType
import fr.scootop.data.model.services.tools.PrestationType
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiServiceToolsService {

    // AGENCE TYPE

    @Headers("Content-Type: application/json")
    @GET("/services/tools/agence/types")
    fun getAgenceTypes(): Response<List<AgenceType>>

    @Headers("Content-Type: application/json")
    @GET("/services/tools/agence/type/{id}")
    fun getAgenceTypeById(@Path("id") id: Integer): Response<AgenceType>

    @Headers("Content-Type: application/json")
    @POST("/services/tools/agence/type")
    fun addAgenceType(@Body agenceType: AgenceType): Response<AgenceType>

    @Headers("Content-Type: application/json")
    @PUT("/services/tools/agence/type/{id}")
    fun updateAgenceType(@Path("id") id: Integer, @Body agenceType: AgenceType): Response<AgenceType>

    @Headers("Content-Type: application/json")
    @DELETE("/services/tools/agence/type/{id}")
    fun deleteAgenceType(@Path("id") id: Integer): Response<String>

    //PRESTATION TYPE

    @Headers("Content-Type: application/json")
    @GET("/services/tools/prestations")
    fun getPrestationsType(): Response<List<PrestationType>>

    @Headers("Content-Type: application/json")
    @GET("/services/tools/prestation/{id}")
    fun getPrestationTypeById(@Path("id") id: Integer): Response<PrestationType>

    @Headers("Content-Type: application/json")
    @POST("/services/tools/prestation")
    fun addPrestationType(@Body prestationType: PrestationType): Response<PrestationType>

    @Headers("Content-Type: application/json")
    @PUT("/services/tools/prestation/{id}")
    fun updatePrestationType(@Path("id") id: Integer, @Body prestationType: PrestationType): Response<PrestationType>

    @Headers("Content-Type: application/json")
    @DELETE("/services/tools/prestation/{id}")
    fun deletePrestationType(@Path("id") id: Integer): Response<String>
}