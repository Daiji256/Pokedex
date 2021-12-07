package com.example.pokedex.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * sprites
 */
@Serializable
data class Sprites(
    @SerialName("back_default") val back_default: String,
    @SerialName("front_default") val front_default: String,
)
