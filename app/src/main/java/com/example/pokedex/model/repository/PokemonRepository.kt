package com.example.pokedex.model.repository

/**
 * [Pokemon] の Repository
 */
interface PokemonRepository {

    /**
     * [name] に該当する [Pokemon] を返す
     */
    suspend fun getPokemon(name: String): Pokemon

    /**
     * [Pokedex] を返す
     */
    suspend fun getPokedex(): Pokedex
}
