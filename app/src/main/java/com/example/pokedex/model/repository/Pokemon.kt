package com.example.pokedex.model.repository

/**
 * ポケモンを表すクラス
 */
data class Pokemon(
    val id: Int,
    val name: String,
    val frontImage: NetworkImage,
)
