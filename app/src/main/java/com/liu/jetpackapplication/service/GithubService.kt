package com.liu.jetpackapplication.service

import com.liu.jetpackapplication.model.RepoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories?sort=stars&q=Android")
    suspend fun searchRepos(@Query("page") page: Int, @Query("per_page") prePage: Int): RepoResponse

    companion object {
        private const val BASE_URL = "https://api.github.com/"
        fun create(): GithubService {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(GithubService::class.java)
        }
    }
}