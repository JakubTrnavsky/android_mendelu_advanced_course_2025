package org.example.animalskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform