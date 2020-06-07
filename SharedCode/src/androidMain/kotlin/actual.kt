package com.example.multiplatformapp

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun platformName(): String {
    return "Android"
}

actual val engine: HttpClientEngine = Android.create()
actual val mainDispatcher: CoroutineDispatcher = Dispatchers.Main