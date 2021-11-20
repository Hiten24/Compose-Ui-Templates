package com.example.composeuitemplates.presentation.bottomNavigationScreen

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val contentDescription: String? = null,
    val icon: ImageVector? = null,
//    val selectedIcon: Int? = null
)
