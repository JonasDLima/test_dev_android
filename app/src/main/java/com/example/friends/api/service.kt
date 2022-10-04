package com.example.friends.api

import com.example.friends.models.PaginationUsers
import com.example.friends.models.User
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("users?page=2")
    fun getUsers() : Call<PaginationUsers>

    @GET("user/2")
    fun getUser() : Call<User>
}