package com.example.composeuitemplates.presentation.ecommerce_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.presentation.ecommerce_ui.data.Product
import com.example.composeuitemplates.presentation.ecommerce_ui.data.products
import com.example.composeuitemplates.presentation.ecommerce_ui.data.size
import com.example.composeuitemplates.presentation.ecommerce_ui.data.textColor

@Composable
fun ProductScreen(
    navController: NavController,
    id: Int
) {

    val product = products[id]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            ImageSection(product.image, product.color, Modifier.clickable { navController.navigateUp() })
            Spacer(modifier = Modifier.height(16.dp))
            AboutSection(
                product.productName,
                productDescription = product.productDescription,
                rating = product.rating,
                price = product.price
            )
            Spacer(modifier = Modifier.height(24.dp))
            SizeSection()
            Spacer(modifier = Modifier.height(24.dp))
            DescriptionSection("Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit. Exercitation veniam consequat sunt nostrud amet.")
        }
        AddToCartSection(modifier = Modifier.align(End), product.color)
    }
}

@Composable
fun ImageSection(
    image: Int,
    color: Color,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .background(color, shape = RoundedCornerShape(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = null,
                modifier = modifier
            )
            HeartSection()
        }

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Center)
        )
    }
}

@Composable
fun AboutSection(
    name: String,
    productDescription: String,
    rating: String,
    price: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name, style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = productDescription, color = textColor)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    tint = Color(0xFFFFC000)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = rating)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "(Avg. Rating)")
            }
            Text(
                text = price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun SizeSection() {
    Column {
        Text(text = "Select Size", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(size) {
                SizeItem(it.toString())
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun SizeItem(
    size: String
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(1.dp, textColor, shape = CircleShape),
        contentAlignment = Center
    ) {
        Text(text = size, fontSize = 18.sp, color = textColor)
    }
}

@Composable
fun DescriptionSection(
    description: String
) {
    Column {
        Text(text = "Description", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = description,
            color = textColor
        )
    }
}

@Composable
fun AddToCartSection(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .size(120.dp, 60.dp)
            .background(
                color, shape = RoundedCornerShape(
                    topStart = 30.dp,
                    bottomStart = 30.dp,
                    bottomEnd = 0.dp,
                    topEnd = 0.dp
                )
            ),
        contentAlignment = Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_shopping_cart_24),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Add", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun HeartSection() {
    Box(
        modifier = Modifier
            .size(36.dp)
            .background(Color.White, shape = CircleShape),
        contentAlignment = Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(18.dp)
        )
    }
}

/*
@Preview
@Composable
fun Preview() {
    ProductScreen(products[1])
}*/
