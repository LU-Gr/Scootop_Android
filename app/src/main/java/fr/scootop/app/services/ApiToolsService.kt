package fr.scootop.app.services

import fr.scootop.data.model.tools.*
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

interface ApiToolsService {

    // CLUB

    @Headers("Content-Type: application/json")
    @GET("/tools/clubs")
    fun getClubs(): Observable<List<Club>>

    @Headers("Content-Type: application/json")
    @GET("/tools/club/{id}")
    fun getClubById(@Path("id") id: Long): Call<Club>

    @Headers("Content-Type: application/json")
    @POST("/tools/club")
    fun addClub(@Body club: Club): Call<Club>

    @Headers("Content-Type: application/json")
    @PUT("/tools/club/{id}")
    fun updateClub(@Path("id") id: Long, @Body club: Club): Call<Club>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/club/{id}")
    fun deleteClub(@Path("id") id: Long): Call<String>

    // COMPETITION

    @Headers("Content-Type: application/json")
    @GET("/tools/competitions")
    fun getCompetitions(): Call<List<Competition>>

    @Headers("Content-Type: application/json")
    @GET("/tools/competition/{id}")
    fun getCompetitionById(@Path("id") id: Long): Call<Competition>

    @Headers("Content-Type: application/json")
    @POST("/tools/competition")
    fun addCompetition(@Body competition: Competition): Call<Competition>

    @Headers("Content-Type: application/json")
    @PUT("/tools/competition/{id}")
    fun updateCompetition(@Path("id") id: Long, @Body competition: Competition): Call<Competition>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/competition/{id}")
    fun deleteCompetition(@Path("id") id: Long): Call<String>

    // MATCH

    @Headers("Content-Type: application/json")
    @GET("/tools/matchs")
    fun getMatches(): Call<List<Match>>

    @Headers("Content-Type: application/json")
    @GET("/tools/match/{id}")
    fun getMatchById(@Path("id") id: Long): Call<Match>

    @Headers("Content-Type: application/json")
    @POST("/tools/match")
    fun addMatch(@Body match: Match): Call<Match>

    @Headers("Content-Type: application/json")
    @PUT("/tools/match/{id}")
    fun updateMatch(@Path("id") id: Long, @Body match: Match): Call<Match>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/match/{id}")
    fun deleteMatch(@Path("id") id: Long): Call<String>


    // SAISON

    @Headers("Content-Type: application/json")
    @GET("/tools/saisons")
    fun getSaisons(): Call<List<Saison>>

    @Headers("Content-Type: application/json")
    @GET("/tools/saison/{id}")
    fun getSaisonById(@Path("id") id: Long): Call<Saison>

    @Headers("Content-Type: application/json")
    @POST("/tools/saison")
    fun addSaison(@Body saison: Saison): Call<Saison>

    @Headers("Content-Type: application/json")
    @PUT("/tools/saison/{id}")
    fun updateSaison(@Path("id") id: Long, @Body saison: Saison): Call<Saison>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/saison/{id}")
    fun deleteSaison(@Path("id") id: Long): Call<String>


    // STAT

    @Headers("Content-Type: application/json")
    @GET("/tools/stats")
    fun getStatisticalSheets(): Call<List<StatisticalSheet>>

    @Headers("Content-Type: application/json")
    @GET("/tools/statisticalsheet/{id}")
    fun getStatisticalSheetById(@Path("id") id: Long): Call<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @POST("/tools/statisticalsheet")
    fun addStatisticalSheet(@Body statisticalSheet: StatisticalSheet): Call<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @PUT("/tools/statisticalsheet/{id}")
    fun updateStatisticalSheett(@Path("id") id: Long, @Body statisticalSheet: StatisticalSheet): Call<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/statisticalsheet/{id}")
    fun deleteStatisticalSheet(@Path("id") id: Long): Call<String>

    @Headers("Content-Type: application/json")
    @GET("/tools/stats/{playerId}/{eventId}")
    fun getStatByPLayerAndEvent(@Path("playerId") playerId: Long, @Path("eventId") eventId: Long): Call<StatisticalSheet>



    // TEAM

    @Headers("Content-Type: application/json")
    @GET("/tools/teams")
    fun getTeams(): Observable<List<Team>>

    @Headers("Content-Type: application/json")
    @GET("/tools/team/{id}")
    fun getTeamById(@Path("id") id: Long): Call<Team>

    @Headers("Content-Type: application/json")
    @POST("/tools/team")
    fun addTeam(@Body team: Team): Call<Team>

    @Headers("Content-Type: application/json")
    @PUT("/tools/team/{id}")
    fun updateTeams(@Path("id") id: Long, @Body team: Team): Call<Team>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/tam/{id}")
    fun deleteTeam(@Path("id") id: Long): Call<String>

}