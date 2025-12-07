package org.example.animalskmp

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

class JVMClipboard: Clipboard {
    override fun setString(value: String) {
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(StringSelection(value), null)
    }

}

actual fun getClipboard(): Clipboard = JVMClipboard()