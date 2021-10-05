package com.example.composeuitemplates.presentation.profile_ui

import androidx.compose.ui.graphics.painter.Painter

data class ImageWithText(
    val image: Painter,
    val text: String
)

data class Posts(
    val imageUrl: String,
    val text: String
)