package fr.scootop.app.services

import fr.scootop.data.model.statistics.Action
import fr.scootop.data.model.statistics.Goal
import fr.scootop.data.model.statistics.Pass
import fr.scootop.data.model.statistics.Shoot
import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiStatisticsService {

    // GOAL

    @Headers("Content-Type: application/json")
    @GET("/stats/goals")
    fun getGoals(): Response<List<Goal>>

    @Headers("Content-Type: application/json")
    @GET("/stats/goal/{id}")
    fun getGoalById(@Path("id") id: Integer): Response<Goal>

    @Headers("Content-Type: application/json")
    @POST("/stats/goal")
    fun addGoal(@Body goal: Goal): Response<Goal>

    @Headers("Content-Type: application/json")
    @PUT("/stats/goal/{id}")
    fun updateGoal(@Path("id") id: Integer, @Body goal: Goal): Response<Goal>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/goal/{id}")
    fun deleteGoal(@Path("id") id: Integer): Response<String>

    // ACTION

    @Headers("Content-Type: application/json")
    @GET("/stats/actions")
    fun getActions(): Response<List<Action>>

    @Headers("Content-Type: application/json")
    @GET("/stats/action/{id}")
    fun getActionById(@Path("id") id: Integer): Response<Action>

    @Headers("Content-Type: application/json")
    @POST("/stats/action")
    fun addAction(@Body action: Action): Response<Action>

    @Headers("Content-Type: application/json")
    @PUT("/stats/action/{id}")
    fun updateAction(@Path("id") id: Integer, @Body action: Action): Response<Action>

    @Headers("Content-Type: application/json")
    @DELETE("/stats")
    fun deleteAction(@Path("id") id: Integer): Response<String>

    // ASSIST

    @Headers("Content-Type: application/json")
    @GET("/stats/assists")
    fun getPasses(): Response<List<Pass>>

    @Headers("Content-Type: application/json")
    @GET("/stats/assist/{id}")
    fun getPassById(@Path("id") id: Integer): Response<Pass>

    @Headers("Content-Type: application/json")
    @POST("/stats/assist")
    fun addPass(@Body pass: Pass): Response<Pass>

    @Headers("Content-Type: application/json")
    @PUT("/stats/assist/{id}")
    fun updatePass(@Path("id") id: Integer, @Body pass: Pass): Response<Pass>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/assist/{id}")
    fun deletePass(@Path("id") id: Integer): Response<String>

    // SHOOT

    @Headers("Content-Type: application/json")
    @GET("/stats/shoots")
    fun getShoots(): Response<List<Shoot>>

    @Headers("Content-Type: application/json")
    @GET("/stats/shoot/{id}")
    fun getShootById(@Path("id") id: Integer): Response<Shoot>

    @Headers("Content-Type: application/json")
    @POST("/stats/shoot")
    fun addShoot(@Body shoot: Shoot): Response<Shoot>

    @Headers("Content-Type: application/json")
    @PUT("/stats/shoot/{id}")
    fun updateShoot(@Path("id") id: Integer, @Body shoot: Shoot): Response<Shoot>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/shoot/{id}")
    fun deleteShoot(@Path("id") id: Integer): Response<String>

}