package com.example.multiplatformapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(val _id: String, val en: String, val author: String, val id: String)