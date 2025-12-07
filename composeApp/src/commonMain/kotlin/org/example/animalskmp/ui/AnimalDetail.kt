package org.example.animalskmp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import animalskmp.composeapp.generated.resources.Res
import animalskmp.composeapp.generated.resources.ic_back
import animalskmp.composeapp.generated.resources.ic_copy
import coil3.compose.AsyncImage
import org.example.animalskmp.data.Animal
import org.jetbrains.compose.resources.painterResource

@Composable
fun AnimalDetail(
    animal: Animal,
    showBackButton: Boolean = true,
    onBackClick: () -> Unit = {},
    onCopyText: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Set a fixed height for the image for now
        ) {
            AsyncImage(
                model = animal.image,
                contentDescription = animal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            if (showBackButton) {
                IconButton(
                    modifier = Modifier.align(Alignment.TopStart),
                    onClick = onBackClick,
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_back),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurface),
                        contentDescription = "Back"
                    )
                }
            }
            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = { onCopyText("${animal.name}\n${animal.description}") }
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_copy),
                    contentDescription = "Copy"
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
        ) {
            Text(
                text = animal.name,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = animal.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}