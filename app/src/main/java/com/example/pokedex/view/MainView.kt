package com.example.pokedex.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.pokedex.model.repository.Pokedex
import com.example.pokedex.model.repository.Pokemon
import com.example.pokedex.viewmodel.MainViewModel

/**
 * メイン画面
 *
 * ViewModel の状態に応じて，初期表示，読み込み中表示，詳細表示，エラー表示を切り替えて表示する
 */
@Composable
fun MainView(mainViewModel: MainViewModel) {
    val uiState: MainViewModel.UiState by mainViewModel.uiState

    Column(Modifier.fillMaxWidth()) {
        SearchView(
            searchQuery = mainViewModel.searchQuery,
            onSearchButtonTapped = mainViewModel::onSearchTapped,
        )
        when (uiState) {
            is MainViewModel.UiState.Loading -> {
                LoadingView()
            }
            is MainViewModel.UiState.SuccessPokedex -> {
                PokedexView(pokedex = uiState.requirePokedex(), mainViewModel::onPokemonTapped)
            }
            is MainViewModel.UiState.SuccessPokemon -> {
                PokemonDetailView(pokemon = uiState.requirePokemon(), mainViewModel::backHome)
            }
            else -> {
                ErrorView()
            }
        }
    }
}

// MainViewModel が保持する Pokemon を強制的に取り出す
private fun MainViewModel.UiState.requirePokemon(): Pokemon {
    if (this !is MainViewModel.UiState.SuccessPokemon) throw IllegalStateException("Pokemon is not loaded.")
    return pokemon
}

// MainViewModel が保持する Pokedex を強制的に取り出す
private fun MainViewModel.UiState.requirePokedex(): Pokedex {
    if (this !is MainViewModel.UiState.SuccessPokedex) throw IllegalStateException("Pokedex is not loaded.")
    return pokedex
}
