package com.example.pokedex.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * PokeAPI の pokedex からのレスポンス
 */
@Serializable
data class PokeApiPokedex(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("pokemon_entries") val pokemonEntries: List<PokemonEntry>,
)
