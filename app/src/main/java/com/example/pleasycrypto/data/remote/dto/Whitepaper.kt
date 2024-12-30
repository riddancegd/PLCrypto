package com.example.pleasycrypto.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Whitepaper(
    @field:Json(name = "link")
    val link: String,
    @field:Json(name = "thumbnail")
    val thumbnail: String
)