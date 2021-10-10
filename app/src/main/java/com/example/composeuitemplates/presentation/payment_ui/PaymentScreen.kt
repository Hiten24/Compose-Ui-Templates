package com.example.composeuitemplates.presentation.payment_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeuitemplates.presentation.payment_ui.components.AmountEnterCard
import com.example.composeuitemplates.presentation.payment_ui.components.CustomizedButton
import com.example.composeuitemplates.presentation.payment_ui.components.HeaderCircles
import com.example.composeuitemplates.presentation.payment_ui.components.WalletAmount

@ExperimentalMaterialApi
@Composable
fun PaymentScreen(onPayClicked: () -> Unit) {


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

    ) {
        TopArea {
            HeaderCircles()
            WalletAmount()
            AmountEnterCard()
        }
        CustomizedButton(
            text = "Pay",
            onClick = onPayClicked
        )
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

