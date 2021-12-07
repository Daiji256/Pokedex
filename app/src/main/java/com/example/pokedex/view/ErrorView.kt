package com.example.pokedex.view

import androidx.activity.compose.BackHandler
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/**
 * エラー表示
 */
@Composable
fun ErrorView(backHome: () -> Unit) {
    Text(
        text = "読み込み失敗"
    )
    BackHandler(enabled = true) {
        backHome()
    }
}
