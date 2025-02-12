package com.example.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Links(
    @field:Json(name = "explorer")
    val explorer: List<String>,
    @field:Json(name = "facebook")
    val facebook: List<String>,
    @field:Json(name = "reddit")
    val reddit: List<String>,
    @field:Json(name = "source_code")
    val sourceCode: List<String>,
    @field:Json(name = "website")
    val website: List<String>,
    @field:Json(name = "youtube")
    val youtube: List<String>
)