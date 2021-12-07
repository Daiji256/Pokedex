package com.example.pokedex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * 独自の Application クラス
 *
 * Hilt の @HiltAndroidApp を付与するために作成
 */
@HiltAndroidApp
class PokedexApplication : Application()
