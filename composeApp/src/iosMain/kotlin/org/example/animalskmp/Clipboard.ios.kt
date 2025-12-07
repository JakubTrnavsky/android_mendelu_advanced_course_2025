package org.example.animalskmp

import platform.UIKit.UIPasteboard

class IOSClipboard: Clipboard {
    override fun setString(value: String) {
        UIPasteboard.generalPasteboard.string = value
    }

}

actual fun getClipboard(): Clipboard {
    return IOSClipboard()
}