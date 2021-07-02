package fr.scootop.app.services

import fr.scootop.data.model.statistics.Action
import fr.scootop.data.model.statistics.Goal
import fr.scootop.data.model.statistics.Pass
import fr.scootop.data.model.statistics.Shoot
import retrofit2.Call
import retrofit2.http.*

interface ApiStatisticsService {

    // GOAL

    @Headers("Content-Type: application/json")
    @GET("/stats/goals")
    fun getGoals(): Call<List<Goal>>

    @Headers("Content-Type: application/json")
    @GET("/stats/goal/{id}")
    fun getGoalById(@Path("id") id: Long): Call<Goal>

    @Headers("Content-Type: application/json")
    @POST("/stats/goal")
    fun addGoal(@Body goal: Goal): Call<Goal>

    @Headers("Content-Type: application/json")
    @PUT("/stats/goal/{id}")
    fun updateGoal(@Path("id") id: Long, @Body goal: Goal): Call<Goal>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/goal/{id}")
    fun deleteGoal(@Path("id") id: Long): Call<String>

    // ACTION

    @Headers("Content-Type: application/json")
    @GET("/stats/actions")
    fun getActions(): Call<List<Action>>

    @Headers("Content-Type: application/json")
    @GET("/stats/action/{id}")
    fun getActionById(@Path("id") id: Long): Call<Action>

    @Headers("Content-Type: application/json")
    @POST("/stats/action")
    fun addAction(@Body action: Action): Call<Action>

    @Headers("Content-Type: application/json")
    @PUT("/stats/action/{id}")
    fun updateAction(@Path("id") id: Long, @Body action: Action): Call<Action>

    @Headers("Content-Type: application/json")
    @DELETE("/stats")
    fun deleteAction(@Path("id") id: Long): Call<String>

    // ASSIST

    @Headers("Content-Type: application/json")
    @GET("/stats/assists")
    fun getPasses(): Call<List<Pass>>

    @Headers("Content-Type: application/json")
    @GET("/stats/assist/{id}")
    fun getPassById(@Path("id") id: Long): Call<Pass>

    @Headers("Content-Type: application/json")
    @POST("/stats/assist")
    fun addPass(@Body pass: Pass): Call<Pass>

    @Headers("Content-Type: application/json")
    @PUT("/stats/assist/{id}")
    fun updatePass(@Path("id") id: Long, @Body pass: Pass): Call<Pass>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/assist/{id}")
    fun deletePass(@Path("id") id: Long): Call<String>

    // SHOOT

    @Headers("Content-Type: application/json")
    @GET("/stats/shoots")
    fun getShoots(): Call<List<Shoot>>

    @Headers("Content-Type: application/json")
    @GET("/stats/shoot/{id}")
    fun getShootById(@Path("id") id: Long): Call<Shoot>

    @Headers("Content-Type: application/json")
    @POST("/stats/shoot")
    fun addShoot(@Body shoot: Shoot): Call<Shoot>

    @Headers("Content-Type: application/json")
    @PUT("/stats/shoot/{id}")
    fun updateShoot(@Path("id") id: Long, @Body shoot: Shoot): Call<Shoot>

    @Headers("Content-Type: application/json")
    @DELETE("/stats/shoot/{id}")
    fun deleteShoot(@Path("id") id: Long): Call<String>

}