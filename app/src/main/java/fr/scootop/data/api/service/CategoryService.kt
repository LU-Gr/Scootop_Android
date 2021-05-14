package fr.scootop.data.api.service

import fr.scootop.data.model.Category
import fr.scootop.data.model.Club
import fr.scootop.data.model.Pagination
import retrofit2.http.GET
import rx.Observable

interface CategoryService {

    @GET("api/categories")
    fun getCategories(): Observable<Pagination<Category>>
}