package com.example.composeuitemplates.presentation.bottomNavigationScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun StandardBottomNavigation(
    navController: NavController,
    items: List<BottomNavItem>,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFEEEEEE),
//        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route)
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.Gray,
                enabled = item.icon != null,
                icon = {
                    if (item.icon != null /*&& item.selectedIcon != null*/) {
//                        var icons = painterResource(id = item.icon)
                        /*if (selected) {
                            icons = painterResource(id = item.selectedIcon)
                        }*/
                        Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                    }
                }
            )
        }
    }
}