package org.example.animalskmp

import kotlinx.browser.window

class JsClipboard: Clipboard {
    @OptIn(ExperimentalWasmJsInterop::class)
    override fun setString(value: String) {
        window.navigator.clipboard.writeText(value)
    }
}

actual fun getClipboard(): Clipboard = JsClipboard()