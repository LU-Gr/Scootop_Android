package fr.scootop.app.services

import fr.scootop.data.model.LoginResult
import fr.scootop.data.model.request.RegisterUser
import fr.scootop.data.model.user.Contact
import fr.scootop.data.model.user.User
import fr.scootop.data.model.user.UserType
import retrofit2.Call
import retrofit2.http.*
import rx.Observable


interface ApiUserService {

    // LOGIN

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/user/register")
    fun register(@Body user: RegisterUser): Observable<LoginResult>

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/user/authenticate")
    fun login(
            @Field("username") username:String,
            @Field("password") password:String
    ): Observable<LoginResult>

    // CONTACTS

    @Headers("Content-Type: application/json")
    @GET("/user/contacts")
    fun getContacts(): Call<List<Contact>>

    @Headers("Content-Type: application/json")
    @GET("/user/contact/{id}")
    fun getContactById(@Path("id") id: Long): Call<Contact>

    @Headers("Content-Type: application/json")
    @POST("/user/contact")
    fun addContact(@Body contact: Contact): Call<Contact>

    @Headers("Content-Type: application/json")
    @PUT("/user/contact/{id}")
    fun updateContactById(@Path("id") id: Long, @Body contact: Contact): Call<Contact>

    @Headers("Content-Type: application/json")
    @DELETE("/user/contact/{id}")
    fun deleteContact(@Path("id") id: Long): Call<String>

    // USERS

    @Headers("Content-Type: application/json")
    @GET("/user/users")
    fun getUsers(): Call<List<User>>

    @Headers("Content-Type: application/json")
    @GET("/user/user/{id}")
    fun getUserById(@Path("id") id: Long): Call<User>

    @Headers("Content-Type: application/json")
    @PUT("/user/user/{id}")
    fun updateUserById(@Path("id") id: Long, @Body user: User): Call<User>

    @Headers("Content-Type: application/json")
    @DELETE("/user/user/{id}")
    fun deleteUser(@Path("id") id: Long): Call<String>

    //TYPE

    @Headers("Content-Type: application/json")
    @GET("/user/type")
    fun getUserTypes(): Call<List<UserType>>

    @Headers("Content-Type: application/json")
    @GET("/user/type/{id}")
    fun getUserTypeById(@Path("id") id: Long): Call<UserType>

    @Headers("Content-Type: application/json")
    @PUT("/user/type/{id}")
    fun updateUserTypeById(@Path("id") id: Long, @Body userType: UserType): Call<UserType>

    @Headers("Content-Type: application/json")
    @POST("/user/type")
    fun addUserType(@Body userType: UserType): Call<UserType>

    @Headers("Content-Type: application/json")
    @DELETE("/user/type/{id}")
    fun deleteUserType(@Path("id") id: Long): Call<String>

}