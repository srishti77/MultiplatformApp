package com.example.multiplatformapp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

expect val mainDispatcher: CoroutineDispatcher

@ExperimentalStdlibApi
fun getData(callback: (String) -> Unit) = GlobalScope.launch(mainDispatcher) {
    val message = try {
        QuotesAPI().fetchRandomQuotes()
    } catch (e: Throwable) {
        e.message ?: "An error occurred"
    }
    callback(message)
}