package com.example.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Stats(
    @field:Json(name = "contributors")
    val contributors: Int,
    @field:Json(name = "followers")
    val followers: Int,
    @field:Json(name = "stars")
    val stars: Int,
    @field:Json(name = "subscribers")
    val subscribers: Int
)