package org.example.animalskmp.ui.modifier

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp


fun Modifier.fadeOut(
    brush: Brush,
) = this
    .graphicsLayer { alpha = 0.99f }
    .drawWithContent {
        drawContent()
        drawRect(
            brush = brush,
            blendMode = BlendMode.DstIn,
        )
    }
