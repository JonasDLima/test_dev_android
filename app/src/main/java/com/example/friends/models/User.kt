package com.example.friends.models

import com.google.gson.annotations.SerializedName

data class PaginationUsers(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("data")
    val data: List<User>
)

data class User(
    @SerializedName("id")
    val id: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("avatar")
    val avatar: String
)
