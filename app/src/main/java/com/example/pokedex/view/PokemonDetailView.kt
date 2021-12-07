package com.example.pokedex.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
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
        Image(
            painter = rememberImagePainter(pokemon.frontImage.url.value),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
    }
}
