package com.example.multiplatformapp
import com.example.multiplatformapp.model.Quote
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.json.Json.Default.nonstrict

expect val engine: HttpClientEngine
expect val mainDispatcher: CoroutineDispatcher

@ExperimentalStdlibApi
class ProductsAPI {

    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(nonstrict)
            }
        }
    }

    suspend fun fetchRandomQuotes(): String {
        return client.get<Quote> {
            url(BASE_URL)
        }.en
    }

    companion object {
        const val BASE_URL =
            "https://programming-quotes-api.herokuapp.com/quotes/random"
    }
}