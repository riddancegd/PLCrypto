package com.example.pleasycrypto.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class CoinDetailDto(
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "development_status")
    val developmentStatus: String,
    @field:Json(name = "first_data_at")
    val firstDataAt: String,
    @field:Json(name = "hardware_wallet")
    val hardwareWallet: Boolean,
    @field:Json(name = "hash_algorithm")
    val hashAlgorithm: String,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "is_active")
    val isActive: Boolean,
    @field:Json(name = "is_new")
    val isNew: Boolean,
    @field:Json(name = "last_data_at")
    val lastDataAt: String,
    @field:Json(name = "links")
    val links: Links,
    @field:Json(name = "links_extended")
    val linksExtended: List<LinksExtended>,
    @field:Json(name = "logo")
    val logo: String,
    @field:Json(name = "message")
    val message: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "open_source")
    val openSource: Boolean,
    @field:Json(name = "org_structure")
    val orgStructure: String,
    @field:Json(name = "proof_type")
    val proofType: String,
    @field:Json(name = "rank")
    val rank: Int,
    @field:Json(name = "started_at")
    val startedAt: String,
    @field:Json(name = "symbol")
    val symbol: String,
    @field:Json(name = "tags")
    val tags: List<Tag>,
    @field:Json(name = "team")
    val team: List<TeamMember>,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "whitepaper")
    val whitepaper: Whitepaper
)