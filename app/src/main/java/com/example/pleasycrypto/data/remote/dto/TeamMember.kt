package com.example.pleasycrypto.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class TeamMember(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "position")
    val position: String
)