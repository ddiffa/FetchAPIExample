package dev.hellodiffa.fetchapiexampel.remote

import dev.hellodiffa.fetchapiexampel.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getAllArticle(@Query("sources") source : String, @Query("apiKey") apiKey : String) : NewsResponse
}