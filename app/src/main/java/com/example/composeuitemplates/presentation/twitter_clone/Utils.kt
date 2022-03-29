package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
import com.example.composeuitemplates.R
import com.example.composeuitemplates.presentation.chat_ui.username

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
        userImage = "https://picsum.photos/200",
        username = "Hiten Chwda",
        userid= "chawda_hiten",
        text = "I love Compose UI templates",
        is_liked = true,
        like = "36",
        comment = "10",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        username = "Biren Nayak",
        userid = "birennayak",
        text = "Good morning",
        is_liked = true,
        like = "36",
        comment = "10",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        text = "What a lovely day, is it?",
        username = "Dishant Gandhi",
        userid = "gandhi_dishant",
        is_liked = true,
        like = "36",
        comment = "10",
        retweet = "100"
    ),Tweet(
        userImage = "R.drawable.gojo",
        text = "Did you guys saw Jujutsu Kaisen 0? how was I looking?",
        username = "Satoru Gojo",
        userid = "gojo",
        is_liked = true,
        like = "1M",
        comment = "10k",
        retweet = "1k"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        text = "Spiderman No way Home is one of the best spiderman movies every mad, change my mind",
        username = "Marvel fan",
        userid = "some_marvel_fan",
        is_liked = true,
        like = "90k",
        comment = "10k",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        text = "Eagerly waiting for Thor 4 trailer",
        username = "Jane Foster",
        userid = "new_thor",
        is_liked = false,
        like = "36",
        comment = "10",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        text = "Long day coding",
        username = "Droid City",
        userid = "droidcity",
        is_liked = true,
        like = "36",
        comment = "10",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        text = "Peter Parker 🕷",
        username = "I am Spiderman",
        userid = "peter_parker",
        is_liked = false,
        like = "36",
        comment = "10",
        retweet = "100"
    ),
    Tweet(
        userImage = "https://picsum.photos/200",
        username = "Eren Yeager",
        userid = "ereh",
        text = "Mikasa Ackerman",
        is_liked = true,
        like = "36",
        comment = "10",
        retweet = "100"
    )
)