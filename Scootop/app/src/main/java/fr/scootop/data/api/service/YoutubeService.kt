package fr.scootop.data.api.service

import fr.scootop.BuildConfig
import fr.scootop.data.model.youtube.YTSearchListResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface YoutubeService {

    @GET("/youtube/v3/search")
    fun searchVideos(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 25,
        @Query("type") type: String = "video",
        @Query("videoCaption") caption: String = "closedCaption",
        @Query("part") part: String = "snippet",
        @Query("key") key: String = BuildConfig.YT_SEARCH_API_KEY
    ): Observable<YTSearchListResponse>

}