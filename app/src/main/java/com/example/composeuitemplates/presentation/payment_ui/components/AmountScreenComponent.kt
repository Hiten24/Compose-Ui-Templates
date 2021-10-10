package com.example.composeuitemplates.presentation.payment_ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuitemplates.presentation.payment_ui.components.Data.noRippleClickable
import com.example.composeuitemplates.presentation.payment_ui.components.Data.tipAmounts
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
fun WalletAmount() {
    Column(Modifier.padding(vertical = 16.dp)) {
        Text(
            text = "Compose Wallet",
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp
        )
        Text(
            text = "$20",
            color = GreenLight,
            fontWeight = FontWeight.Bold,
            fontSize = 33.sp
        )
    }
}

@Composable
@Preview
fun AmountEnterCard() {

    var amount by remember {
        mutableStateOf("")
    }
    var selectedTips by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            1.dp, Color.LightGray
        ),
        backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),

            ) {
            Text(text = "Paying to John Doe", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))


            AmountTextField(value = amount, onValueChange = {
                amount = it
            }, placeholder = "Enter Amount")

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Add some tips")
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                tipAmounts.forEach {
                    TipButton(title = it, isToggled = selectedTips == it) { title, change ->
                        selectedTips = if (change) {
                            title
                        } else {
                            ""
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }


            }

            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = message, onValueChange = {
                    message = it
                }, colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedLabelColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ), modifier = Modifier
                    .align(CenterHorizontally),
                placeholder = {
                    Text(text = "Add Message")
                }
            )

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
    val color = if (isToggled) GreenLight else Color.Gray
    Card(
        shape = CircleShape,
        border = BorderStroke(1.dp, color = color),
        modifier = Modifier.noRippleClickable {
            onToggleChange(title, isToggled.not())
        }
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            color = color
        )
    }
}

@Composable
fun AmountTextField(value: String, onValueChange: (String) -> Unit, placeholder: String) {

    TextField(
        value = value, onValueChange = onValueChange, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.DarkGray,
            unfocusedLabelColor = Color.Gray,

            ),
        placeholder = {
            Text(text = placeholder, color = Color.Gray)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.AttachMoney, contentDescription = "Money")
        }, keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 20.sp)
    )
}


@ExperimentalMaterialApi
@Composable
fun PayButton(modifier: Modifier=Modifier,onClick: () -> Unit) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Button(
            onClick = onClick, colors = ButtonDefaults.buttonColors(
                backgroundColor = GreenLight,
            ), shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text(text = "Pay")
        }
    }

}

object Data {
    val tipAmounts = listOf("$10", "$20", "$30")
    inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier =
        composed {
            clickable(indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                onClick()
            }
        }
}