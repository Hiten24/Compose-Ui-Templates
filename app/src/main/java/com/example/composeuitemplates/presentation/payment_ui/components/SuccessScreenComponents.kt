package com.example.composeuitemplates.presentation.payment_ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.composeuitemplates.presentation.payment_ui.ui.GreenLight


@Composable
@Preview
fun SuccessCard() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    Box(
        Modifier
            .fillMaxWidth()
    ) {

        Card(
            shape = CircleShape, modifier = Modifier
                .align(Alignment.TopCenter)
                .zIndex(25f),
            backgroundColor = Color.White
        ) {
            Icon(
                imageVector = Icons.Filled.Verified,
                contentDescription = "",
                tint = GreenLight,
                modifier = Modifier
                    .padding(16.dp)
                    .size(50.dp)

            )
        }
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(60.dp))
            Card(
                modifier = Modifier
                    .zIndex(20f)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color.LightGray,
                                Color.Transparent
                            )
                        )
                    ), shape = RoundedCornerShape(8.dp),
                
            ) {

                Column(
                    Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(26.dp))
                        Text(text = "Sent!", color = GreenLight)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Transfer Done",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Info(
                            leftText = "Sent to ",
                            rightText = "John Doe",
                            showRightSubtitle = true,
                            rightSubtitle = "91293293"
                        )

                        Info(leftText = "Transaction ID", rightText = "8163836723")
                        Info(
                            leftText = "Date/Time",
                            rightText = "21 Oct 2021",
                            showRightSubtitle = true,
                            rightSubtitle = "12:00 AM"
                        )
                        Info(
                            leftText = "Debited From",
                            rightText = "Wallet - $20.00",
                            showRightSubtitle = true,
                            rightSubtitle = "xxx 8239 - $10"
                        )

                    }
                    Canvas(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp), onDraw = {

                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, size.height / 2),
                            end = Offset(size.width, size.height / 2),
                            pathEffect = pathEffect
                        )
                        drawCircle(
                            color = Color(
                                0xffffffff
                            ),
                            radius = 50f,
                            center = Offset(x = 0f, y = size.height / 2)
                        )
                        drawCircle(
                            color = Color(
                                0xffffffff
                            ),
                            radius = 50f,
                            center = Offset(x = size.width, y = size.height / 2)
                        )
                    })

                    Text(text = "Sent")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "$30.00", color = GreenLight, fontSize = 30.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }

    }
}


@Composable

fun Info(
    leftText: String,
    rightText: String,
    rightSubtitle: String = "",
    showRightSubtitle: Boolean = false
) {
    Row {
        Text(
            text = leftText,
            modifier = Modifier.fillMaxWidth(0.5f),
            color = Color.Gray,
            fontSize = 20.sp


        )
        Column(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(
                text = rightText,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            if (showRightSubtitle)
                Text(
                    text = rightSubtitle,
                    color = Color.Gray,
                    fontSize = 15.sp


                )
        }

    }
    Spacer(modifier = Modifier.height(12.dp))

}