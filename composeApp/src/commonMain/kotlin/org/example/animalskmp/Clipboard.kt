package org.example.animalskmp

interface Clipboard {
    fun setString(value: String)
}

expect fun getClipboard(): Clipboard