package fr.scootop.data.api.service

import fr.scootop.data.model.Category
import retrofit2.http.GET
import rx.Observable

interface CategoryService {

    @GET("api/categories")
    fun getCategories(): Observable<List<Category>>
}