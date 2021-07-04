package fr.scootop.data.api.service

import fr.scootop.data.model.Club
import retrofit2.http.GET
import rx.Observable

interface ClubService {

    @GET("api/clubs")
    fun getClubs(): Observable<List<Club>>
}
