package fr.scootop.data.api.service

import fr.scootop.data.model.ShortlistCollectionItem
import fr.scootop.data.model.ShortlistItem
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

interface ShortlistItemService {

    @GET("api/users/{id}/shortlist_items.json")
    fun getShortlistItems(@Path("id") userId: Int): Observable<List<ShortlistCollectionItem>>

    @POST("api/shortlist_items.json")
    fun addShortlistItem(@Body shortlistItem: ShortlistItem): Observable<ShortlistItem>

    @DELETE("api/shortlist_items/{id}.json")
    fun deleteShortlistItem(@Path("id") shortlistItemId: Int): Observable<Void>

}
