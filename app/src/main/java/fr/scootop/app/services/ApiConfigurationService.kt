package fr.scootop.app.services

import fr.scootop.data.model.configuration.*
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

interface ApiConfigurationService {

    //ACTION TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/action/types")
    fun getActionTypes(): Call<List<ActionType>>

    @Headers("Content-Type: application/json")
    @GET("/configuration/action/type/{id}")
    fun getActionTypeById(@Path("id") id: Long): Call<ActionType>

    @Headers("Content-Type: application/json")
    @POST("/configuration/action/type")
    fun addActionType(@Body actionType: ActionType): Call<ActionType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/action/type/{id}")
    fun updateActionTypeById(@Path("id") id: Long, @Body actionType: ActionType): Call<ActionType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/action/type/{id}")
    fun deleteActionType(@Path("id") id: Long): Call<String>

    // CATEGORY

    @Headers("Content-Type: application/json")
    @GET("/configuration/categories")
    fun getCategories(): Observable<List<Category>>

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/{id}")
    fun getCategoryById(@Path("id") id: Long): Call<Category>

    @Headers("Content-Type: application/json")
    @POST("/configuration/category")
    fun addCategory(@Body category: Category): Call<Category>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/category/{id}")
    fun updateCategory(@Path("id") id: Long, @Body category: Category): Call<Category>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/category/{id}")
    fun deleteCategory(@Path("id") id: Long): Call<String>

    //CATEGORY TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/type/{id}")
    fun getCategoryTypeById(@Path("id") id: Long): Call<CategoryType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/types")
    fun getCategoriesTypes(): Call<List<CategoryType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/category/type")
    fun addCategoryType(@Body categoryType: CategoryType): Call<CategoryType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/category/type/{id}")
    fun updateCategoryType(@Path("id") id: Long, @Body categoryType: CategoryType): Call<CategoryType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/category/type/{id}")
    fun deleteCategoryType(@Path("id") id: Long): Call<String>


    //COMPETITION TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/competition/type/{id}")
    fun getCompetitionTypeById(@Path("id") id: Long): Call<CompetitionType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/competition/types")
    fun getCompetitionTypes(): Call<List<CompetitionType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/competition/type")
    fun addCompetitionType(@Body competitionType: CompetitionType): Call<CompetitionType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/competition/type/{id}")
    fun updateCompetitionType(@Path("id") id: Long, @Body competitionType: CompetitionType): Call<CompetitionType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/competition/type/{id}")
    fun deleteCompetitionType(@Path("id") id: Long): Call<String>

    // DIVISION

    @Headers("Content-Type: application/json")
    @GET("/configuration/division/{id}")
    fun getDivisionById(@Path("id") id: Long): Call<Division>

    @Headers("Content-Type: application/json")
    @GET("/configuration/divisions")
    fun getDivisions(): Observable<List<Division>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/division")
    fun addDivision(@Body division: Division): Call<Division>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/division/{id}")
    fun updateDivision(@Path("id") id: Long, @Body division: Division): Call<Division>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/division/{id}")
    fun deleteDivision(@Path("id") id: Long): Call<String>

    // LEAGUE

    @Headers("Content-Type: application/json")
    @GET("/configuration/league/{id}")
    fun getLeagueById(@Path("id") id: Long): Call<League>

    @Headers("Content-Type: application/json")
    @GET("/configuration/leagues")
    fun getLeagues(): Call<List<League>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/league")
    fun addLeague(@Body league: League): Call<League>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/league/{id}")
    fun updateLeague(@Path("id") id: Long, @Body league: League): Call<League>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/league/{id}")
    fun deleteLeague(@Path("id") id: Long): Call<String>

    // POSTE

    @Headers("Content-Type: application/json")
    @GET("/configuration/poste/{id}")
    fun getPosteById(@Path("id") id: Long): Call<Poste>

    @Headers("Content-Type: application/json")
    @GET("/configuration/postes")
    fun getPostes(): Observable<List<Poste>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/poste")
    fun addPoste(@Body poste: Poste): Call<Poste>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/poste/{id}")
    fun updatePoste(@Path("id") id: Long, @Body poste: Poste): Call<Poste>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/poste/{id}")
    fun deletePoste(@Path("id") id: Long): Call<String>

    // STADE

    @Headers("Content-Type: application/json")
    @GET("/configuration/stade/{id}")
    fun getStadeById(@Path("id") id: Long): Call<Stade>

    @Headers("Content-Type: application/json")
    @GET("/configuration/stades")
    fun getStades(): Call<List<Stade>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/stade")
    fun addStade(@Body stade: Stade): Call<Stade>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/stade/{id}")
    fun updateStade(@Path("id") id: Long, @Body stade: Stade): Call<Stade>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/stade/{id}")
    fun deleteStade(@Path("id") id: Long): Call<String>

    //TOUCH TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/touch/type/{id}")
    fun getTouchTypeById(@Path("id") id: Long): Call<TouchType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/touch/types")
    fun getTouchTypes(): Call<List<TouchType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/touch/type")
    fun addTouchType(@Body touchType: TouchType): Call<TouchType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/touch/type/{id}")
    fun updateTouchType(@Path("id") id: Long, @Body touchType: TouchType): Call<TouchType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/touch/type/{id}")
    fun deleteTouchType(@Path("id") id: Long): Call<String>

}