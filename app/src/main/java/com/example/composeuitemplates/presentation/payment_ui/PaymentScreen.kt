package com.example.composeuitemplates.presentation.payment_ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeuitemplates.presentation.payment_ui.components.AmountEnterCard
import com.example.composeuitemplates.presentation.payment_ui.components.HeaderCircles
import com.example.composeuitemplates.presentation.payment_ui.components.PayButton
import com.example.composeuitemplates.presentation.payment_ui.components.WalletAmount

@ExperimentalMaterialApi
@Composable
fun PaymentScreen() {


    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        TopArea {
            HeaderCircles()
            WalletAmount()
            AmountEnterCard()
        }
        PayButton(modifier = Modifier.align(Alignment.BottomCenter)) {

        }
    }

}

@Composable
fun TopArea(content: @Composable () -> Unit) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        content()
    }
}

