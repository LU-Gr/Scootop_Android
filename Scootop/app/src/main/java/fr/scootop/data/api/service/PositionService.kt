package fr.scootop.data.api.service

import fr.scootop.data.model.Pagination
import fr.scootop.data.model.Position
import retrofit2.http.GET
import rx.Observable

interface PositionService {

    @GET("api/positions")
    fun getPositions(): Observable<Pagination<Position>>

}