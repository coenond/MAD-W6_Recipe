package com.coen.mad_w6_recipe.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FoodAPI {

    companion object {
        private val baseUrl = "https://www.food2fork.com/api/"
        const val key = "95967374a901fc52a450c0f369079399"

        fun start(): FoodAPIService {
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(FoodAPIService::class.java)
        }
    }
}