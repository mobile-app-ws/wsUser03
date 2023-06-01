package com.example.worldskills_app.models

import kotlinx.serialization.Serializable

@Serializable
data class NewsModels(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val image: String
)