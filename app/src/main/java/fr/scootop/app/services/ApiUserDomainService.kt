package fr.scootop.app.services

import fr.scootop.app.search.SearchPlayerAdapter
import fr.scootop.data.model.configuration.ActionType
import fr.scootop.data.model.services.ComparatorParams
import fr.scootop.data.model.user.domain.*
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiUserDomainService {

    // CHAIRMAN

    @Headers("Content-Type: application/json")
    @GET("/user/domain/chairmens")
    fun getChairmen(): Response<List<Chairman>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/chairman/{id}")
    fun getChairmanById(@Path("id") id: Integer): Response<Chairman>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/chairman")
    fun addChairman(@Body chairman: Chairman): Response<Chairman>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/chairman/{id}")
    fun updateChairman(@Path("id") id: Integer, @Body chairman: Chairman): Response<Chairman>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/chairman/{id}")
    fun deleteChairman(@Path("id") id: Integer): Response<String>

    // SCOOT

    @Headers("Content-Type: application/json")
    @GET("/user/domain/scoots")
    fun getScoots(): Response<List<Scoot>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/scoot/{id}")
    fun getScootById(@Path("id") id: Integer): Response<Scoot>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/scoot")
    fun addScoot(@Body scoot: Scoot): Response<Scoot>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/scoot/{id}")
    fun updateScoot(@Path("id") id: Integer, @Body scoot: Scoot): Response<Scoot>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/scoot/{id}")
    fun deleteScoot(@Path("id") id: Integer): Response<String>

    // PLAYER

    @Headers("Content-Type: application/json")
    @GET("/user/domain/players")
    fun getPlayers(): Response<List<Player>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/{id}")
    fun getPlayerById(@Path("id") id: Integer): Response<Player>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/player")
    fun addPlayer(@Body player: Player): Response<Player>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/player/{id}")
    fun updatePlayer(@Path("id") id: Integer, @Body player: Player): Response<Player>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/player/{id}")
    fun deletePlayer(@Path("id") id: Integer): Response<String>

    // COACH

    @Headers("Content-Type: application/json")
    @GET("/user/domain/coaches")
    fun getCoaches(): Response<List<Coach>>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/coach/{id}")
    fun getCoachById(@Path("id") id: Integer): Response<Coach>

    @Headers("Content-Type: application/json")
    @POST("/user/domain/coach")
    fun addCoach(@Body coach: Coach): Response<Coach>

    @Headers("Content-Type: application/json")
    @PUT("/user/domain/coach/{id}")
    fun updateCoach(@Path("id") id: Integer, @Body coach: Coach): Response<Coach>

    @Headers("Content-Type: application/json")
    @DELETE("/user/domain/coach/{id}")
    fun deleteCoach(@Path("id") id: Integer): Response<String>

    // FICHE PLAYER

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/fiche")
    fun getPlayerResume(@Body comparatorParams: ComparatorParams): Response<FicheJoueur>

    @Headers("Content-Type: application/json")
    @GET("/user/domain/player/comparator")
    fun compareTwoPlayers(@Body comparatorParams: ComparatorParams): Response<FicheJoueur>

    // PLAYER SEARCH

    @Headers("Content-Type: application/json")
    @GET("/user/domain/players/search")
    fun searchPlayer(@Body searchPlayer: SearchPlayerAdapter): Response<PlayerSearchList>


    // MATCHSHEET SCOOT

    @Headers("Content-Type: application/json")
    @GET("/user/domain/matchsheet/{id}/scoots")
    fun getScootByMatch(@Path("id") id: Integer): Response<List<Scoot>>


}