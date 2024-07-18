package com.hendjn.meals.api

import com.hendjn.meals.models.CategoriesResponse
import retrofit2.http.GET

val recipesService: ApiService = ApiConfigs.api.create(ApiService::class.java)


interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}