package com.example.composeuitemplates.mainscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class ScreenNames(
    val name: String,
    val route: String
)

val screens = listOf(
    ScreenNames("Chat Screen", Screen.ChatScreen.route),
    ScreenNames("Profile Screen", Screen.ProfileScreen.route),
    ScreenNames("Ecommerce Ui", Screen.EcommerceScreen.route)
)

@ExperimentalMaterialApi
@Composable
fun MainScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        LazyColumn {
            items(screens){screen ->
                Item(name = screen.name){
                    navController.navigate(screen.route)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun Item(
    name: String,
    onclick: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        onClick = onclick
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp)
        )
    }
}