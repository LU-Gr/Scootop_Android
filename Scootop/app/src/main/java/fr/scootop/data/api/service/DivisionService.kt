package fr.scootop.data.api.service

import fr.scootop.data.model.Division
import fr.scootop.data.model.Pagination
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface DivisionService {

    @GET("api/divisions")
    fun getDivisions(@Query("country.code") countryCode: String?): Observable<Pagination<Division>>

}