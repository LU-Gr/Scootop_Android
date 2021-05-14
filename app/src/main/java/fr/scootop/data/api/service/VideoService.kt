package fr.scootop.data.api.service

import fr.scootop.data.model.Video
import fr.scootop.data.model.request.CreateVideo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface VideoService {

    @POST("api/videos")
    fun createVideo(@Body request: CreateVideo): Observable<Video>

}