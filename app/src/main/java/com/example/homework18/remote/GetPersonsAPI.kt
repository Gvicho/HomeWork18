package com.example.homework18.remote


import com.example.homework18.ServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPersonsAPI {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<ServerResponse>
}