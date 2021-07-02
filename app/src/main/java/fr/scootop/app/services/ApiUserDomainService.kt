package fr.scootop.app.services

import fr.scootop.app.search.SearchPlayerAdapter
import fr.scootop.data.model.services.ComparatorParams
import fr.scootop.data.model.user.domain.*
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

interface ApiUserDomainService {

    // CHAIRMAN

    @Headers("Content-Type: application/json")
    @GET("/user/domain/chairmens")
    fun getChairmen(): Call<List<Chairman>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/chairman/{id}")
    fun getChairmanById(@Path("id") id: Long): Call<Chairman>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/chairman")
    fun addChairman(@Body chairman: Chairman): Call<Chairman>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/chairman/{id}")
    fun updateChairman(@Path("id") id: Long, @Body chairman: Chairman): Call<Chairman>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/chairman/{id}")
    fun deleteChairman(@Path("id") id: Long): Call<String>

    // SCOOT

    @Headers("Content-Type: application/json")
    @GET("/user/domain/scoots")
    fun getScoots(): Call<List<Scoot>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/scoot/{id}")
    fun getScootById(@Path("id") id: Long): Call<Scoot>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/scoot")
    fun addScoot(@Body scoot: Scoot): Call<Scoot>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/scoot/{id}")
    fun updateScoot(@Path("id") id: Long, @Body scoot: Scoot): Call<Scoot>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/scoot/{id}")
    fun deleteScoot(@Path("id") id: Long): Call<String>

    // PLAYER

    @Headers("Content-Type: application/json")
    @GET("/user/domain/players")
    fun getPlayers(): Call<List<Player>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/{id}")
    fun getPlayerById(@Path("id") id: Long): Observable<Player>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/player")
    fun addPlayer(@Body player: Player): Call<Player>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/player/{id}")
    fun updatePlayer(@Path("id") id: Long, @Body player: Player): Call<Player>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/player/{id}")
    fun deletePlayer(@Path("id") id: Long): Call<String>

    // COACH

    @Headers("Content-Type: application/json")
    @GET("/user/domain/coaches")
    fun getCoaches(): Call<List<Coach>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/coach/{id}")
    fun getCoachById(@Path("id") id: Long): Call<Coach>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/coach")
    fun addCoach(@Body coach: Coach): Call<Coach>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/coach/{id}")
    fun updateCoach(@Path("id") id: Long, @Body coach: Coach): Call<Coach>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/coach/{id}")
    fun deleteCoach(@Path("id") id: Long): Call<String>

    // FICHE PLAYER

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/fiche")
    fun getPlayerResume(@Body comparatorParams: ComparatorParams): Call<FicheJoueur>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/comparator")
    fun compareTwoPlayers(@Body comparatorParams: ComparatorParams): Call<FicheJoueur>

    // PLAYER SEARCH

    @Headers("Content-Type: application/json")
    @GET("/user/domain/players/search")
    fun searchPlayer(@Body searchPlayer: SearchPlayerAdapter): Call<PlayerSearchList>


    // MATCHSHEET SCOOT

    @Headers("Content-Type: application/json")
    @GET("/user/domain/matchsheet/{id}/scoots")
    fun getScootByMatch(@Path("id") id: Long): Call<List<Scoot>>


}