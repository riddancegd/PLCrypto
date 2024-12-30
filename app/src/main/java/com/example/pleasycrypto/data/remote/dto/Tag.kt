package com.example.pleasycrypto.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Tag(
    @field:Json(name = "coin_counter")
    val coinCounter: Int,
    @field:Json(name = "ico_counter")
    val icoCounter: Int,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "name")
    val name: String
)