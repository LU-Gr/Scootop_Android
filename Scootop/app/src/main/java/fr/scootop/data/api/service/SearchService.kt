package fr.scootop.data.api.service

import fr.scootop.data.model.PlayerSearchItem
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface SearchService {

    @GET("api/search/players")
    fun searchPlayers(@Query("query") text: String): Observable<List<PlayerSearchItem>>
}
