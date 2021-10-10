package com.example.composeuitemplates.presentation.payment_ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuitemplates.presentation.payment_ui.ui.GreenLight
import com.example.composeuitemplates.presentation.payment_ui.ui.YellowLight

@Composable
@Preview
fun HeaderCircles() {

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp), onDraw = {
        val canvasHeight = size.height
        drawCircle(
            color = YellowLight,
            center = Offset(
                x = 170f,
                y = -50f
            ),
            radius = canvasHeight,
        )
        drawCircle(
            color = GreenLight,
            center = Offset(
                x = 0f,
                y = 0f
            ),
            radius = canvasHeight
        )
    })
}

@Composable
@Preview
fun AmountEnterCard() {

    Card(
        shape = RoundedCornerShape(8.dp), border = BorderStroke(
            1.dp, Color.Gray
        )
    ) {
        Column {
            Text(text = "Enter Amount",fontSize = 20.sp)

        }
    }
}

@Composable
@Preview
fun TipButton(
    title: String = "$10",
    isToggled: Boolean = false,
    onToggleChange: (String, Boolean) -> Unit = { it, change ->
    }
) {
    Card(shape = CircleShape, border = BorderStroke(1.dp, GreenLight)) {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .toggleable(value = isToggled, enabled = true, onValueChange = {
                    onToggleChange(title, it)
                }),
            color = GreenLight
        )
    }
}