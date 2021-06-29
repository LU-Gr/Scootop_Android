package fr.scootop.app.services

import fr.scootop.data.model.configuration.*

import retrofit2.http.Headers
import retrofit2.Response
import retrofit2.http.*

interface ApiConfigurationService {

    //ACTION TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/action/types")
    fun getActionTypes(): Response<List<ActionType>>

    @Headers("Content-Type: application/json")
    @GET("/configuration/action/type/{id}")
    fun getActionTypeById(@Path("id") id: Integer): Response<ActionType>

    @Headers("Content-Type: application/json")
    @POST("/configuration/action/type")
    fun addActionType(@Body actionType: ActionType): Response<ActionType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/action/type/{id}")
    fun updateActionTypeById(@Path("id") id: Integer, @Body actionType: ActionType): Response<ActionType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/action/type/{id}")
    fun deleteActionType(@Path("id") id: Integer): Response<String>

    // CATEGORY

    @Headers("Content-Type: application/json")
    @GET("/configuration/categories")
    fun getCategories(): Response<List<Category>>

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/{id}")
    fun getCategoryById(@Path("id") id: Integer): Response<Category>

    @Headers("Content-Type: application/json")
    @POST("/configuration/category")
    fun addCategory(@Body category: Category): Response<Category>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/category/{id}")
    fun updateCategory(@Path("id") id: Integer, @Body category: Category): Response<Category>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/category/{id}")
    fun deleteCategory(@Path("id") id: Integer): Response<String>

    //CATEGORY TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/type/{id}")
    fun getCategoryTypeById(@Path("id") id: Integer): Response<CategoryType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/category/types")
    fun getCategoriesTypes(): Response<List<CategoryType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/category/type")
    fun addCategoryType(@Body categoryType: CategoryType): Response<CategoryType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/category/type/{id}")
    fun updateCategoryType(@Path("id") id: Integer, @Body categoryType: CategoryType): Response<CategoryType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/category/type/{id}")
    fun deleteCategoryType(@Path("id") id: Integer): Response<String>


    //COMPETITION TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/competition/type/{id}")
    fun getCompetitionTypeById(@Path("id") id: Integer): Response<CompetitionType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/competition/types")
    fun getCompetitionTypes(): Response<List<CompetitionType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/competition/type")
    fun addCompetitionType(@Body competitionType: CompetitionType): Response<CompetitionType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/competition/type/{id}")
    fun updateCompetitionType(@Path("id") id: Integer, @Body competitionType: CompetitionType): Response<CompetitionType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/competition/type/{id}")
    fun deleteCompetitionType(@Path("id") id: Integer): Response<String>

    // DIVISION

    @Headers("Content-Type: application/json")
    @GET("/configuration/division/{id}")
    fun getDivisionById(@Path("id") id: Integer): Response<Division>

    @Headers("Content-Type: application/json")
    @GET("/configuration/divisions")
    fun getDivisions(): Response<List<Division>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/division")
    fun addDivision(@Body division: Division): Response<Division>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/division/{id}")
    fun updateDivision(@Path("id") id: Integer, @Body division: Division): Response<Division>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/division/{id}")
    fun deleteDivision(@Path("id") id: Integer): Response<String>

    // LEAGUE

    @Headers("Content-Type: application/json")
    @GET("/configuration/league/{id}")
    fun getLeagueById(@Path("id") id: Integer): Response<League>

    @Headers("Content-Type: application/json")
    @GET("/configuration/leagues")
    fun getLeagues(): Response<List<League>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/league")
    fun addLeague(@Body league: League): Response<League>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/league/{id}")
    fun updateLeague(@Path("id") id: Integer, @Body league: League): Response<League>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/league/{id}")
    fun deleteLeague(@Path("id") id: Integer): Response<String>

    // POSTE

    @Headers("Content-Type: application/json")
    @GET("/configuration/poste/{id}")
    fun getPosteById(@Path("id") id: Integer): Response<Poste>

    @Headers("Content-Type: application/json")
    @GET("/configuration/postes")
    fun getPostes(): Response<List<Poste>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/poste")
    fun addPoste(@Body poste: Poste): Response<Poste>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/poste/{id}")
    fun updatePoste(@Path("id") id: Integer, @Body poste: Poste): Response<Poste>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/poste/{id}")
    fun deletePoste(@Path("id") id: Integer): Response<String>

    // STADE

    @Headers("Content-Type: application/json")
    @GET("/configuration/stade/{id}")
    fun getStadeById(@Path("id") id: Integer): Response<Stade>

    @Headers("Content-Type: application/json")
    @GET("/configuration/stades")
    fun getStades(): Response<List<Stade>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/stade")
    fun addStade(@Body stade: Stade): Response<Stade>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/stade/{id}")
    fun updateStade(@Path("id") id: Integer, @Body stade: Stade): Response<Stade>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/stade/{id}")
    fun deleteStade(@Path("id") id: Integer): Response<String>

    //TOUCH TYPE

    @Headers("Content-Type: application/json")
    @GET("/configuration/touch/type/{id}")
    fun getTouchTypeById(@Path("id") id: Integer): Response<TouchType>

    @Headers("Content-Type: application/json")
    @GET("/configuration/touch/types")
    fun getTouchTypes(): Response<List<TouchType>>

    @Headers("Content-Type: application/json")
    @POST("/configuration/touch/type")
    fun addTouchType(@Body touchType: TouchType): Response<TouchType>

    @Headers("Content-Type: application/json")
    @PUT("/configuration/touch/type/{id}")
    fun updateTouchType(@Path("id") id: Integer, @Body touchType: TouchType): Response<TouchType>

    @Headers("Content-Type: application/json")
    @DELETE("/configuration/touch/type/{id}")
    fun deleteTouchType(@Path("id") id: Integer): Response<String>

}