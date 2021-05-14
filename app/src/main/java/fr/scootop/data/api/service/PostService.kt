package fr.scootop.data.api.service

import fr.scootop.data.model.Post
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface PostService {

    @POST("api/posts")
    fun createPost(@Body post: Post): Observable<Post>

}