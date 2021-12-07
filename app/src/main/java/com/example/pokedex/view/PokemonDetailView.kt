package com.example.pokedex.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokedex.model.repository.Pokemon
import java.util.*

@Composable
fun PokemonDetailView(pokemon: Pokemon, backHome: () -> Unit) {
    Column {
        Text(
            text = "No. " + pokemon.id.toString()
        )
        Text(
            text = pokemon.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
        )
        Image(
            painter = rememberImagePainter(pokemon.frontImage.url.value),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
    }
    BackHandler(enabled = true) {
        backHome()
    }
}
