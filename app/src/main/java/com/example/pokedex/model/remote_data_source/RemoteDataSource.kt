package com.example.pokedex.model.remote_data_source

/**
 * サーバーからのレスポンスを取り出す Data Source
 */
interface RemoteDataSource {

    /**
     * サーバーからのレスポンスを [PokeApiPokemon] として返す
     */
    suspend fun getPokeApiPokemon(name: String): PokeApiPokemon

    /**
     * サーバーからのレスポンスを [PokeApiPokedex] として返す
     */
    suspend fun getPokeApiPokedex(): PokeApiPokedex
}
