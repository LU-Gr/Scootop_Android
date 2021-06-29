package fr.scootop.app.services

import fr.scootop.data.model.user.Contact
import fr.scootop.data.model.user.User
import fr.scootop.data.model.user.UserType
import retrofit2.Response
import retrofit2.http.*


interface ApiUserService {

    // LOGIN

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/user/register")
    fun registerUser(@Body user: User): Response<String>

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/user/authenticate")
    fun login(
            @Field("username") username:String,
            @Field("password") password:String
    ): Response<String>

    // CONTACTS

    @Headers("Content-Type: application/json")
    @GET("/user/contacts")
    fun getContacts(): Response<List<Contact>>

    @Headers("Content-Type: application/json")
    @GET("/user/contact/{id}")
    fun getContactById(@Path("id") id: Integer): Response<Contact>

    @Headers("Content-Type: application/json")
    @POST("/user/contact")
    fun addContact(@Body contact: Contact): Response<Contact>

    @Headers("Content-Type: application/json")
    @PUT("/user/contact/{id}")
    fun updateContactById(@Path("id") id: Integer, @Body contact: Contact): Response<Contact>

    @Headers("Content-Type: application/json")
    @DELETE("/user/contact/{id}")
    fun deleteContact(@Path("id") id: Integer): Response<String>

    // USERS

    @Headers("Content-Type: application/json")
    @GET("/user/users")
    fun getUsers(): Response<List<User>>

    @Headers("Content-Type: application/json")
    @GET("/user/user/{id}")
    fun getUserById(@Path("id") id: Integer): Response<User>

    @Headers("Content-Type: application/json")
    @PUT("/user/user/{id}")
    fun updateUserById(@Path("id") id: Integer, @Body user: User): Response<User>

    @Headers("Content-Type: application/json")
    @POST("/user/user")
    fun addUser(@Body user: User): Response<User>

    @Headers("Content-Type: application/json")
    @DELETE("/user/user/{id}")
    fun deleteUser(@Path("id") id: Integer): Response<String>

    //TYPE

    @Headers("Content-Type: application/json")
    @GET("/user/type")
    fun getUserTypes(): Response<List<UserType>>

    @Headers("Content-Type: application/json")
    @GET("/user/type/{id}")
    fun getUserTypeById(@Path("id") id: Integer): Response<UserType>

    @Headers("Content-Type: application/json")
    @PUT("/user/type/{id}")
    fun updateUserTypeById(@Path("id") id: Integer, @Body userType: UserType): Response<UserType>

    @Headers("Content-Type: application/json")
    @POST("/user/type")
    fun addUserType(@Body userType: UserType): Response<UserType>

    @Headers("Content-Type: application/json")
    @DELETE("/user/type/{id}")
    fun deleteUserType(@Path("id") id: Integer): Response<String>

}