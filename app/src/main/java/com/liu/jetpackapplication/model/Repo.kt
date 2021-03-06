package com.liu.jetpackapplication.model

import com.google.gson.annotations.SerializedName


data class Repo(
    val id: Int,
    val name: String,
    val description: String?,
    @SerializedName("stargazers_count")
    val starCount: Int
)