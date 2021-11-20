package com.example.composeuitemplates.presentation.bottomNavigationScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeuitemplates.presentation.bottomNavigationScreen.Sample.*

@ExperimentalMaterialApi
@Composable
fun BottomNavigationScreen() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        StandardScaffold(
            bottomNavItems = bottomNavItems,
            navController = navController,
//            showBottomBar = shouldShowBottomBar(navBackStackEntry)
        ) {
//            Navigation(navController = navController)
            NavHost(navController = navController, startDestination = "sample_screen-1" ) {
                composable(route = "sample_screen-1") {
                    SampleScreen1()
                }
                composable(route = "sample_screen-2") {
                    SampleScreen2()
                }
                composable(route = "sample_screen-3") {
                    SampleScreen3()
                }
                composable(route = "sample_screen-4") {
                    SampleScreen4()
                }
            }
        }
    }
}