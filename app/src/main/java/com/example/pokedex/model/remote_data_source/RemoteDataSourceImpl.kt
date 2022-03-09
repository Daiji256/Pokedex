package com.example.pokedex.model.remote_data_source

import javax.inject.Inject

/**
 * [RemoteDataSource] の実装クラス
 */
class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
) : RemoteDataSource {
    override suspend fun getPokeApiPokemon(name: String): PokeApiPokemon {
        val response = apiClient.getPokeApiPokemon(name)
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        }
        throw HttpException()
    }

    override suspend fun getPokeApiPokedex(): PokeApiPokedex {
        val response = apiClient.getPokeApiPokedex()
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        }
        throw HttpException()
    }
}

/**
 * Response が isSuccessful != true だった時に投げられる例外
 */
class HttpException : Throwable()
