package com.example.composeuitemplates.mainscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composeuitemplates.presentation.chat_ui.ChatScreen
import com.example.composeuitemplates.presentation.ecommerce_ui.EcommerceHomeScreen
import com.example.composeuitemplates.presentation.ecommerce_ui.ProductScreen
import com.example.composeuitemplates.presentation.login_signup_ui.LoginScreen
import com.example.composeuitemplates.presentation.login_signup_ui.SignupScreen
import com.example.composeuitemplates.presentation.payment_ui.PaymentScreen
import com.example.composeuitemplates.presentation.profile_ui.ProfileScreen

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.ChatScreen.route){
            ChatScreen(navController = navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
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

        composable(route = Screen.SignupScreen.route) {
            SignupScreen(navController = navController)
        }

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        navigation(
            route = Screen.PaymentScreen.route,
            startDestination = PaymentScreens.AmountScreen.route
        ) {
            composable(PaymentScreens.AmountScreen.route){
                PaymentScreen()
            }
        }
    }
}