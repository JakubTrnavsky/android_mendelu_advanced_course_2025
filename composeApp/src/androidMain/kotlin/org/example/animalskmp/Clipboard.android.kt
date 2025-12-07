package org.example.animalskmp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

class AndroidClipboard(
    private val context: Context
) : Clipboard {
    override fun setString(value: String) {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
        clipboardManager?.setPrimaryClip(ClipData.newPlainText(value, value))
    }
}

var androidClipboardInstance: Clipboard? = null

actual fun getClipboard(): Clipboard = requireNotNull(androidClipboardInstance)