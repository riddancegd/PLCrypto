package com.example.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class LinksExtended(
    @field:Json(name = "stats")
    val stats: Stats,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "url")
    val url: String
)