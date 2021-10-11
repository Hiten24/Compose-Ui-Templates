package com.example.composeuitemplates.presentation.payment_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeuitemplates.presentation.payment_ui.components.CustomizedButton
import com.example.composeuitemplates.presentation.payment_ui.components.HeaderCircles
import com.example.composeuitemplates.presentation.payment_ui.components.SuccessCard

@ExperimentalMaterialApi
@Composable
fun SuccessScreen(onHomeClicked:()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(26.dp)
        ) {

            HeaderCircles()
            Spacer(modifier = Modifier.height(16.dp))
            SuccessCard()

        }
        CustomizedButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = "Back to Home",
            onClick = onHomeClicked)

    }
}