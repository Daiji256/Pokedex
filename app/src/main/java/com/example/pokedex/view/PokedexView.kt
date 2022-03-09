package com.example.pokedex.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.repository.Pokedex

@Composable
fun PokedexView(pokedex: Pokedex, onPokemonTapped: (name: String) -> Unit) {
    LazyColumn {
        pokedex.pokemonEntries.forEach { pokemonEntry ->
            item {
                Text(
                    text = "No. " + pokemonEntry.entryNumber.toString() +
                            ": " + pokemonEntry.pokemonSpecies.name,
                    modifier = Modifier
                        .height(30.dp)
                        .clickable { onPokemonTapped(pokemonEntry.entryNumber.toString()) },
                )
            }
        }
    }
}