package com.example.pokedex.model.remote_data_source

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit を用いた PokeAPI のクライアント
 */
interface ApiClient {
    @GET("pokedex/national")
    suspend fun getPokeApiPokedex(): Response<PokeApiPokedex>

    @GET("pokemon/{name}")
    suspend fun getPokeApiPokemon(@Path("name") name: String): Response<PokeApiPokemon>
}
