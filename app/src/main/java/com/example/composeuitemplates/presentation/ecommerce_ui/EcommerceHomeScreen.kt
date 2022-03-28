package com.example.composeuitemplates.presentation.ecommerce_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.mainscreen.Screen
import com.example.composeuitemplates.presentation.ecommerce_ui.data.Product
import com.example.composeuitemplates.presentation.ecommerce_ui.data.products
import com.example.composeuitemplates.presentation.ecommerce_ui.data.textColor

val searchText = mutableStateOf("")

@Composable
fun EcommerceHomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        TopBar()
        TitleSection()
        Spacer(modifier = Modifier.height(16.dp))
        SearchSection()
        Spacer(modifier = Modifier.height(24.dp))
        ProductsSection(navController)
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null
        )
    }
}

@Composable
fun TitleSection() {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Nike Collection",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Everything you need at just one place.",
            color = Color(0xFFCDCDCD)
        )
    }
}

@Composable
fun SearchSection() {
    OutlinedTextField(
        value = searchText.value,
        onValueChange = {
            searchText.value = it
        },
        placeholder = {
            Text(text = "Search here...", color = Color(0xFFCCCCCC))
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF4F4F4), shape = CircleShape),
        shape = CircleShape,
        singleLine = true,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }
    )
}

@Composable
fun ProductsSection(navController: NavController) {
    LazyColumn {
        items(products) { product ->
            ProductItem(
                product,
                onItemClick = {
                    navController.navigate(Screen.EcommerceProductScreen.route + "/${product.id}")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onItemClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = product.color, shape = RoundedCornerShape(24.dp))
            .height(180.dp)
            .clickable(onClick = onItemClick),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(product.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.4f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(product.productName, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.productDescription,
                    color = Color(0xFFB1B1B1)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = product.price, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Buy",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .background(Color(0xFF313131), shape = CircleShape)
                            .padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                        color = textColor
                    )
                }
            }

        }
    }
}

/*
@Preview
@Composable
fun Preview() {
    EcommerceHomeScreen()
}*/
