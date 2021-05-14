package fr.scootop.data.api.service

import fr.scootop.data.model.Board
import retrofit2.http.GET
import rx.Observable

interface BoardService {

    @GET("api/board")
    fun getBoard(): Observable<Board>
}
