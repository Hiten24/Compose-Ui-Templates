package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.res.painterResource
import com.example.composeuitemplates.R

val menuList = listOf(
    SingleMenuItem(
        Icons.Outlined.Person,
        "Profile"
    ),
    SingleMenuItem(
        Icons.Outlined.Description,
        "Lists"
    ),
    SingleMenuItem(
        Icons.Outlined.Topic,
        "Topic"
    ),
    SingleMenuItem(
        Icons.Outlined.BookmarkBorder,
        "Bookmark"
    ),
    SingleMenuItem(
        Icons.Outlined.Bolt,
        "Moments"
    ),
    SingleMenuItem(
        Icons.Outlined.Payments,
        "Monetization"
    )
)

val bottomNavItems = listOf(
    BottomNavItemTwitter(
        route = "Home",
        icon = R.drawable.ic_home,
        selected = true
    ),
    BottomNavItemTwitter(
        route = "Search",
        icon = R.drawable.ic_search,
        selected = false
    ),
    BottomNavItemTwitter(
        route = "Notifications",
        icon = R.drawable.ic_notification,
        selected = false
    ),
    BottomNavItemTwitter(
        route = "Messages",
        icon = R.drawable.ic_message,
        selected = false
    )
)


val feeds = listOf(

)