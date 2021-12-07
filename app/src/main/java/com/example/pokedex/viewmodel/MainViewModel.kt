package com.example.pokedex.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.model.repository.Pokemon
import com.example.pokedex.model.repository.Pokedex
import com.example.pokedex.model.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * メイン画面に対する ViewModel
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    /**
     * View の状態を表す sealed class
     */
    sealed class UiState {

        /**
         * 読み込み中
         */
        object Loading : UiState()

        /**
         * Pokemon の読み込み成功
         */
        data class SuccessPokemon(val pokemon: Pokemon) : UiState()

        /**
         * Pokedex の読み込み成功
         */
        data class SuccessPokedex(val pokedex: Pokedex) : UiState()

        /**
         * 読み込み失敗
         */
        object Failure : UiState()
    }

    /**
     * View の状態を [UiState] として表す MutableState
     */
    val uiState: MutableState<UiState> = mutableStateOf(UiState.Loading)

    /**
     * 検索フォームに入力された文字列を表す MutableState
     */
    val searchQuery: MutableState<String> = mutableStateOf("")

    fun onViewCreated() {
        viewModelScope.launch {
            uiState.value = UiState.Loading
            runCatching {
                pokemonRepository.getPokedex()
            }.onSuccess {
                uiState.value = UiState.SuccessPokedex(pokedex = it)
            }.onFailure {
                uiState.value = UiState.Failure
            }
        }
    }

    /**
     * 検索を実行する。
     *
     * searchQuery から検索フォームに入力された文字列を取得し，
     * Repository を経由してユーザを問い合わせる。
     */
    fun onSearchTapped() {
        val searchQuery: String = searchQuery.value

        viewModelScope.launch {
            uiState.value = UiState.Loading
            runCatching {
                pokemonRepository.getPokemon(name = searchQuery.lowercase(Locale.getDefault()))
            }.onSuccess {
                uiState.value = UiState.SuccessPokemon(pokemon = it)
            }.onFailure {
                uiState.value = UiState.Failure
            }
        }
    }
}
