package com.coen.mad_w6_recipe.api

import com.coen.mad_w6_recipe.model.APISearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodAPIService {

    @GET("search/?key=${FoodAPI.key}")
    fun get(): Single<APISearchResponse>
}