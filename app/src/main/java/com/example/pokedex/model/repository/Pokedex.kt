package com.example.pokedex.model.repository

import com.example.pokedex.model.remote_data_source.PokemonEntry

/**
 * ポケモン図鑑（リスト）を表すクラス
 */
data class Pokedex(
    val id: Int,
    val name: String,
    val pokemonEntries: List<PokemonEntry>,
)
