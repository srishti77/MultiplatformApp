package com.example.multiplatformapp

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalStdlibApi
fun getData(callback: (String) -> Unit) = GlobalScope.launch(mainDispatcher) {
    val message = try {
        ProductsAPI().fetchRandomQuotes()
    } catch (e: Throwable) {
        e.message ?: "An error occurred"
    }
    callback(message)
}