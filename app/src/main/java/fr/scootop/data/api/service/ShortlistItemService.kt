package fr.scootop.data.api.service

import fr.scootop.data.model.ShortlistCollectionItem
import fr.scootop.data.model.ShortlistItem
import retrofit2.http.*
import rx.Observable

interface ShortlistItemService {

    @GET("api/users/{id}/shortlist_items.json")
    fun getShortlistItems(@Path("id") userId: Long): Observable<List<ShortlistCollectionItem>>

    @POST("api/shortlist_items.json")
    fun addShortlistItem(@Body shortlistItem: ShortlistItem): Observable<ShortlistItem>

    @DELETE("api/shortlist_items/{id}.json")
    fun deleteShortlistItem(@Path("id") shortlistItemId: Int): Observable<Void>

}
