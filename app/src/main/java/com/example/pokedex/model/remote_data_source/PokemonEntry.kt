package com.example.pokedex.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * PokemonEntry
 */
@Serializable
data class PokemonEntry(
    @SerialName("entry_number") val entryNumber: Int,
    @SerialName("pokemon_species") val pokemonSpecies: PokemonSpecies,
)
