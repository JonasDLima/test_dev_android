package com.example.friends.api

import com.example.friends.models.PaginationUsers
import com.example.friends.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DAO {
    fun getData(): MutableList<User> {
        val retrofitClient = Controller
            .getRetrofitInstance("https://reqres.in/api/")

        val endpoint = retrofitClient.create(Service::class.java)
        val callback = endpoint.getUsers()
        var listUsers: MutableList<User> = mutableListOf()

        callback.enqueue(object : Callback<PaginationUsers> {
            override fun onFailure(call: Call<PaginationUsers>, t: Throwable) {
//                Toast.makeText(, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<PaginationUsers>, response: Response<PaginationUsers>) {
                response.body()?.data?.forEach { user ->
                    listUsers.add(user)
                }
            }
        })
        return listUsers
    }
}