package com.example.composeuitemplates.mainscreen

sealed class Screen(val route: String) {
    object MainScreen: Screen("Main_screen")
    object ChatScreen: Screen("Chat_screen")
    object ProfileScreen: Screen("Profile_screen")
    object ProfileScreen2: Screen("Profile_screen_2")
    object EcommerceScreen: Screen("ecommerce_screen")
    object EcommerceProductScreen: Screen("ecommerce_product_screen")
    object SignupScreen: Screen("signup_screen")
    object LoginScreen: Screen("login_screen")
    object PaymentScreen:Screen("payment_screen")
}

sealed class PaymentScreens(val route: String){
    object AmountScreen:PaymentScreens("payment_amount")
    object SuccessScreen:PaymentScreens("payment_success")
}