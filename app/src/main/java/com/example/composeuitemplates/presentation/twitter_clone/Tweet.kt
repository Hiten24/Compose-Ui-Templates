package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.ui.graphics.painter.Painter

data class Tweet(
    val userImage: Painter,
    val username: String,
    val userid: String,
    val text: String,
    val is_liked: Boolean=false,
    val like: Int=0,
    val comment: Int=0,
    val retweet: Int=0
)
