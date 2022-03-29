package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.ui.graphics.painter.Painter

data class Tweet(
    val userImage: String,
    val username: String,
    val userid: String,
    val text: String,
    val is_liked: Boolean=false,
    val like: String,
    val comment: String,
    val retweet: String
)
