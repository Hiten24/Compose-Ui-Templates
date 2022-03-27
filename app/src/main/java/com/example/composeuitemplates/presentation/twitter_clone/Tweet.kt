package com.example.composeuitemplates.presentation.twitter_clone

data class Tweet(
    val user: String,
    val text: String,
    val is_liked: Boolean=false,
    val like: Int=0,
    val comment: Int=0,
    val retweet: Int=0
)
