package com.example.composeuitemplates.presentation.twitter_clone.twitter_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.composeuitemplates.presentation.twitter_clone.Tweet

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Hom Screen")
    }
}

@Composable
fun SingleFeed(
    tweet: Tweet
){
    Row(
        modifier = Modifier.fillMaxWidth(),
    ){
        Image(
            painter = tweet.userImage,
            contentDescription = null,
            modifier = Modifier.size(40.dp).clip(CircleShape)
        )

    }
}

@Composable
fun FeedSection(){

}
