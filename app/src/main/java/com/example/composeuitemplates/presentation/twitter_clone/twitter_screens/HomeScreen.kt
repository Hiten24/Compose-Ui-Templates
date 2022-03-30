package com.example.composeuitemplates.presentation.twitter_clone.twitter_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import com.example.composeuitemplates.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeuitemplates.presentation.twitter_clone.Tweet
import com.example.composeuitemplates.presentation.twitter_clone.feeds
import com.example.composeuitemplates.ui.theme.red
import com.example.composeuitemplates.ui.theme.twitterBlack
import com.example.composeuitemplates.ui.theme.twitterDarkGray
import com.example.composeuitemplates.ui.theme.twitterLightGray

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FeedSection()
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleFeed(
    tweet: Tweet
){
    Divider()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = rememberImagePainter(tweet.userImage),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(8.dp))
            {
                Row {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = tweet.username,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,

                        )
                    )
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "@${tweet.userid}",
                        style = TextStyle(
                            color = twitterDarkGray,
                            fontWeight = FontWeight.Light
                        )
                    )
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "1h",
                        style = TextStyle(
                            color = twitterDarkGray,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = tweet.text,
                    style = TextStyle(
                        color = twitterBlack,
                        fontWeight = FontWeight.Normal
                    )
                )
                Row(
                    modifier = Modifier.padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_comment),
                            contentDescription = null,
                            tint = twitterLightGray
                        )
                        Spacer(modifier =Modifier.width(4.dp))
                        Text(text = tweet.comment)
                    }
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.ic_retweet),
                            contentDescription = null,
                            tint = twitterLightGray
                        )
                        Spacer(modifier =Modifier.width(4.dp))
                        Text(text = tweet.retweet)
                    }
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ){
                        var likeIcon = R.drawable.ic_heart
                        var tint = twitterLightGray
                        Button(
                            onClick = {
                                likeIcon = R.drawable.ic_heart_filled
                                tint = red
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = likeIcon),
                                contentDescription = null,
                                tint = tint
                            )
                            Text(text = tweet.like)
                        }

                    }
                }


            }

        }
    }
    Divider()

}

@Composable
fun FeedSection(){
    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        state = listState
    ){

        items(feeds){
            SingleFeed(tweet = it)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview(){
    HomeScreen()
}