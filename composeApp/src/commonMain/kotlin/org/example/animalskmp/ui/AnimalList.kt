package org.example.animalskmp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.example.animalskmp.data.Animal
import org.example.animalskmp.ui.modifier.fadeOut

@Composable
fun AnimalList(
    animals: List<Animal>,
    onItemClick: (Animal) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberLazyListState()

    val density = LocalDensity.current
    val fadeOutHeight = with(density) { 96.dp.toPx() }

    LazyColumn(
        modifier = modifier.fadeOut(
            Brush.verticalGradient(
                colors = listOf(Transparent, Black),
                endY = fadeOutHeight,
            )
        ),
        state = state,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues()
    ) {
        items(items = animals) { animal ->
            AnimalListItem(
                animal = animal,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(animal) }
                    .padding(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
            )
        }
    }
}

@Composable
fun AnimalListItem(
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        Text(
            text = animal.name,
            style = MaterialTheme.typography.headlineSmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}