package fr.scootop.app.services

import fr.scootop.data.model.tools.*
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiToolsService {

    // CLUB

    @Headers("Content-Type: application/json")
    @GET("/tools/clubs")
    fun getClubs(): Response<List<Club>>

    @Headers("Content-Type: application/json")
    @GET("/tools/club/{id}")
    fun getClubById(@Path("id") id: Integer): Response<Club>

    @Headers("Content-Type: application/json")
    @POST("/tools/club")
    fun addClub(@Body club: Club): Response<Club>

    @Headers("Content-Type: application/json")
    @PUT("/tools/club/{id}")
    fun updateClub(@Path("id") id: Integer, @Body club: Club): Response<Club>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/club/{id}")
    fun deleteClub(@Path("id") id: Integer): Response<String>

    // COMPETITION

    @Headers("Content-Type: application/json")
    @GET("/tools/competitions")
    fun getCompetitions(): Response<List<Competition>>

    @Headers("Content-Type: application/json")
    @GET("/tools/competition/{id}")
    fun getCompetitionById(@Path("id") id: Integer): Response<Competition>

    @Headers("Content-Type: application/json")
    @POST("/tools/competition")
    fun addCompetition(@Body competition: Competition): Response<Competition>

    @Headers("Content-Type: application/json")
    @PUT("/tools/competition/{id}")
    fun updateCompetition(@Path("id") id: Integer, @Body competition: Competition): Response<Competition>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/competition/{id}")
    fun deleteCompetition(@Path("id") id: Integer): Response<String>

    // MATCH

    @Headers("Content-Type: application/json")
    @GET("/tools/matchs")
    fun getMatches(): Response<List<Match>>

    @Headers("Content-Type: application/json")
    @GET("/tools/match/{id}")
    fun getMatchById(@Path("id") id: Integer): Response<Match>

    @Headers("Content-Type: application/json")
    @POST("/tools/match")
    fun addMatch(@Body match: Match): Response<Match>

    @Headers("Content-Type: application/json")
    @PUT("/tools/match/{id}")
    fun updateMatch(@Path("id") id: Integer, @Body match: Match): Response<Match>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/match/{id}")
    fun deleteMatch(@Path("id") id: Integer): Response<String>


    // SAISON

    @Headers("Content-Type: application/json")
    @GET("/tools/saisons")
    fun getSaisons(): Response<List<Saison>>

    @Headers("Content-Type: application/json")
    @GET("/tools/saison/{id}")
    fun getSaisonById(@Path("id") id: Integer): Response<Saison>

    @Headers("Content-Type: application/json")
    @POST("/tools/saison")
    fun addSaison(@Body saison: Saison): Response<Saison>

    @Headers("Content-Type: application/json")
    @PUT("/tools/saison/{id}")
    fun updateSaison(@Path("id") id: Integer, @Body saison: Saison): Response<Saison>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/saison/{id}")
    fun deleteSaison(@Path("id") id: Integer): Response<String>


    // STAT

    @Headers("Content-Type: application/json")
    @GET("/tools/stats")
    fun getStatisticalSheets(): Response<List<StatisticalSheet>>

    @Headers("Content-Type: application/json")
    @GET("/tools/statisticalsheet/{id}")
    fun getStatisticalSheetById(@Path("id") id: Integer): Response<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @POST("/tools/statisticalsheet")
    fun addStatisticalSheet(@Body statisticalSheet: StatisticalSheet): Response<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @PUT("/tools/statisticalsheet/{id}")
    fun updateStatisticalSheett(@Path("id") id: Integer, @Body statisticalSheet: StatisticalSheet): Response<StatisticalSheet>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/statisticalsheet/{id}")
    fun deleteStatisticalSheet(@Path("id") id: Integer): Response<String>

    @Headers("Content-Type: application/json")
    @GET("/tools/stats/{playerId}/{eventId}")
    fun getStatByPLayerAndEvent(@Path("playerId") playerId: Integer, @Path("eventId") eventId: Integer): Response<StatisticalSheet>



    // TEAM

    @Headers("Content-Type: application/json")
    @GET("/tools/teams")
    fun getTeams(): Response<List<Team>>

    @Headers("Content-Type: application/json")
    @GET("/tools/team/{id}")
    fun getTeamById(@Path("id") id: Integer): Response<Team>

    @Headers("Content-Type: application/json")
    @POST("/tools/team")
    fun addTeam(@Body team: Team): Response<Team>

    @Headers("Content-Type: application/json")
    @PUT("/tools/team/{id}")
    fun updateTeams(@Path("id") id: Integer, @Body team: Team): Response<Team>

    @Headers("Content-Type: application/json")
    @DELETE("/tools/tam/{id}")
    fun deleteTeam(@Path("id") id: Integer): Response<String>

}