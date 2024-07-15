package com.hendjn.meals

import retrofit2.http.GET

val recpesService =   ApiConfigs.api.create(ApiService::class.java)


interface ApiService{

    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
}