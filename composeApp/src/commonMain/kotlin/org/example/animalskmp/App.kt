package org.example.animalskmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.example.animalskmp.data.Animal
import org.example.animalskmp.data.AnimalMock
import org.example.animalskmp.ui.AnimalDetail
import org.example.animalskmp.ui.AnimalList
import org.example.animalskmp.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
@Preview
fun App() {
    AppTheme {
        val navigator = rememberListDetailPaneScaffoldNavigator<Animal>()
        val animals = remember { AnimalMock.mockList() }
        val coroutineScope = rememberCoroutineScope()
        val clipboard = remember { getClipboard() }

        ListDetailPaneScaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            directive = navigator.scaffoldDirective,
            value = navigator.scaffoldValue,
            listPane = {
                AnimatedPane {
                    AnimalList(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface),
                        animals = animals,
                        onItemClick = { item ->
                            coroutineScope.launch {
                                // Navigate to the detail pane with the passed item
                                navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, item)
                            }
                        },
                    )
                }
            },
            detailPane = {
                AnimatedPane {
                    // Show the detail pane content if selected item is available
                    navigator.currentDestination?.contentKey?.let { animal ->
                        AnimalDetail(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surface)
                                .systemBarsPadding(),
                            animal = animal,
                            showBackButton = navigator.canNavigateBack(),
                            onBackClick = {
                                coroutineScope.launch {
                                    navigator.navigateBack()
                                }
                            },
                            onCopyText = { clipboard.setString(it) },
                        )
                    }
                }
            },
        )
    }
}