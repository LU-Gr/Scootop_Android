package fr.scootop.data.api.service

import fr.scootop.data.model.Pagination
import fr.scootop.data.model.Team
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface TeamService {

    @GET("api/teams")
    fun getTeams(): Observable<Pagination<Team>>

    @GET("api/teams/{id}.json")
    fun getTeam(@Path("id") teamId: Int?): Observable<Team>
}
