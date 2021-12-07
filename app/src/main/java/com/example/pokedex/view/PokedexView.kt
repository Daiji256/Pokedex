package com.example.pokedex.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.model.repository.Pokedex

@Composable
fun PokedexView(pokedex: Pokedex) {
    LazyColumn {
        pokedex.pokemonEntries.forEach { pokemonEntry ->
            item {
                Text(
                    text = "No. " + pokemonEntry.entryNumber.toString() +
                            ": " + pokemonEntry.pokemonSpecies.name
                )
            }
        }
    }
}