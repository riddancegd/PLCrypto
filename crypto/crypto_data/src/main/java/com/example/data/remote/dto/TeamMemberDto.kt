package com.example.data.remote.dto


import com.squareup.moshi.Json


data class TeamMemberDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "position")
    val position: String
)