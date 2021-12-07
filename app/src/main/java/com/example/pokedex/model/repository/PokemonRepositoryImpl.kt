package com.example.pokedex.model.repository

import com.example.pokedex.model.remote_data_source.PokeApiPokemon
import com.example.pokedex.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

/**
 * [PokemonRepository] の実装クラス
 */
class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : PokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
        return remoteDataSource.getPokeApiPokemon(name).toPokemon()
    }
}

// [PokeApiPokemon] を [Pokemon] に変換する拡張関数
private fun PokeApiPokemon.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        frontImage = NetworkImage(url = Url(sprites.front_default)),
    )
}
