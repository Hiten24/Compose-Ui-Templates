package com.example.composeuitemplates.mainscreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composeuitemplates.presentation.chat_ui.ChatScreen
import com.example.composeuitemplates.presentation.ecommerce_ui.EcommerceHomeScreen
import com.example.composeuitemplates.presentation.ecommerce_ui.ProductScreen
import com.example.composeuitemplates.presentation.ecommerce_ui.data.Product

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.EcommerceScreen.route
    ){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.ChatScreen.route){
            ChatScreen(navController = navController)
        }
        composable(route = Screen.EcommerceScreen.route) {
            EcommerceHomeScreen(navController = navController)
        }
        composable(
            route = Screen.EcommerceProductScreen.route + "/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("productId")
            ProductScreen(navController, id!!)
        }
    }
}