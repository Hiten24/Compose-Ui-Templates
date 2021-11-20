package com.example.composeuitemplates.presentation.bottomNavigationScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@ExperimentalMaterialApi
@Composable
fun StandardScaffold(
    bottomNavItems: List<BottomNavItem>,
    navController: NavController,
    showBottomBar: Boolean = true,
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    backgroundColor = Color(0xFFEEEEEE),
                    cutoutShape = CircleShape,
                    elevation = 10.dp
                ) {
                    StandardBottomNavigation(
                        items = bottomNavItems,
                        navController = navController
                    )
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}