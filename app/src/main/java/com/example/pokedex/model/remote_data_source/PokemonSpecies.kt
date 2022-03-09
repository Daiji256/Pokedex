package com.example.pokedex.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * PokemonSpecies
 */
@Serializable
data class PokemonSpecies(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String,
)
