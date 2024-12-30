package com.example.pleasycrypto.data.remote.dto


import com.squareup.moshi.Json


data class CoinDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "is_active")
    val isActive: Boolean,
    @field:Json(name = "is_new")
    val isNew: Boolean,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "rank")
    val rank: Int,
    @field:Json(name = "symbol")
    val symbol: String,
    @field:Json(name = "type")
    val type: String
)