package com.example.pokedex.model.remote_data_source

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * [ApiClient] を生成するクラス
 */
class ApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://pokeapi.co/api/v2/"
    }

    private val json = Json { ignoreUnknownKeys = true }

    /**
     * [ApiClient] を返す
     */
    @ExperimentalSerializationApi
    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(ApiClient::class.java)
    }
}
