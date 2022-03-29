package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
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
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "I love Compose UI templates",
        is_liked = true,
        like = 36,
        comment = 10,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Good morning",
        is_liked = true,
        like = 36,
        comment = 10,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "What a lovely day, is it?",
        is_liked = true,
        like = 36,
        comment = 10,
        retweet = 100
    ),Tweet(
        userImage = painterResource(R.drawable.gojo),
        text = "Did you guys saw Jujutsu Kaisen 0? how was I looking?",
        is_liked = true,
        like = 10000000,
        comment = 100000,
        retweet = 1000
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Spiderman No way Home is one of the best spiderman movies every mad, change my mind",
        is_liked = true,
        like = 9000000,
        comment = 10000,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Eagerly waiting for Thor 4 trailer",
        is_liked = false,
        like = 36,
        comment = 10,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Long day coding",
        is_liked = true,
        like = 36,
        comment = 10,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Peter Parker 🕷",
        is_liked = false,
        like = 36,
        comment = 10,
        retweet = 100
    ),
    Tweet(
        userImage = rememberImagePainter("https://picsum.photos/200"),
        text = "Mikasa Ackerman",
        is_liked = true,
        like = 36,
        comment = 10,
        retweet = 100
    )
)