package com.example.pokedex.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * PokeAPI の pokemon からのレスポンス
 */
@Serializable
data class PokeApiPokemon(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("sprites") val sprites: Sprites,
)
