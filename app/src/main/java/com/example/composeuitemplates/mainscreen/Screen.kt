package com.example.composeuitemplates.mainscreen

sealed class Screen(val route: String) {
    object MainScreen: Screen("Main_screen")
    object ChatScreen: Screen("Chat_screen")
    object ProfileScreen: Screen("Profile_screen")
    object EcommerceScreen: Screen("ecommerce_screen")
    object EcommerceProductScreen: Screen("ecommerce_product_screen")
}