package com.example.pokedex.model.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * [PokemonRepository] の Module
 */
@Module
@InstallIn(ViewModelComponent::class)
class PokemonRepositoryModule {

    /**
     * [PokemonRepository] の DI に用いられるインスタンスを生成して返す
     */
    @Provides
    fun providePokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository {
        return pokemonRepositoryImpl
    }
}
