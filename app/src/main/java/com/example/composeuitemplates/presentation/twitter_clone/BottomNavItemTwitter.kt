package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.ui.graphics.painter.Painter


data class BottomNavItemTwitter(
    val route: String,
    val contentDescription: String? = null,
    val icon: Int? = null,
    val selected: Boolean
)