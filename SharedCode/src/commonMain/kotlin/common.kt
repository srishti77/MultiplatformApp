package com.example.multiplatformapp

expect fun platformName(): String

fun getMessage() : String {
    return "Application running on: ${platformName()}"
}