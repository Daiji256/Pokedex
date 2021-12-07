package com.example.pokedex.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.model.repository.Pokemon

@Composable
fun PokemonDetailView(pokemon: Pokemon) {
    Column {
        Text(
            text = pokemon.id.toString()
        )
        Text(
            text = pokemon.name
        )
        Text(
            text = pokemon.frontImage.url.value
        )
    }
}
