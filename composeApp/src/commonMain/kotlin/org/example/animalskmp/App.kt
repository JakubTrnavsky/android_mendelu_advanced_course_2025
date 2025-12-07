package org.example.animalskmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.example.animalskmp.data.Animal
import org.example.animalskmp.data.AnimalMock
import org.example.animalskmp.ui.AnimalDetail
import org.example.animalskmp.ui.AnimalList
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val animals = remember { AnimalMock.mockList() }
        var selectedAnimalState by remember { mutableStateOf<Animal?>(null) }

        when (val selectedAnimal = selectedAnimalState) {
            null -> {
                AnimalList(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface),
                    animals = animals,
                    onItemClick = { clickedAnimal ->
                        selectedAnimalState = clickedAnimal
                    },
                )
            }

            else -> {
                AnimalDetail(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface)
                        .systemBarsPadding(),
                    animal = selectedAnimal,
                    onBackClick = { selectedAnimalState = null },
                )
            }
        }
    }
}