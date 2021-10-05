package com.example.composeuitemplates.mainscreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeuitemplates.presentation.chat_ui.ChatScreen
import com.example.composeuitemplates.presentation.profile_ui.ProfileScreen

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

    }
}