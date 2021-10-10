package com.example.composeuitemplates.presentation.payment_ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuitemplates.presentation.payment_ui.components.HeaderCircles

@Composable
fun SuccessScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)){
        TopArea {
            HeaderCircles()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}