package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.ui.theme.ComposeUiTempletesTheme
import com.example.composeuitemplates.ui.theme.twitterBlack
import com.example.composeuitemplates.ui.theme.twitterxxLightGray
import kotlinx.coroutines.launch

@Composable
fun TwitterClone(navController: NavController?=null){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    /*Row(
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Image(
                            painter = painterResource(R.drawable.gojo),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape).size(42.dp)
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_twitter),
                            contentDescription = null,
                            modifier = Modifier.size(42.dp)
                        )
                    }*/

                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch{ scaffoldState.drawerState.open() }
                        },
                    ){
                        Image(
                            painter = painterResource(R.drawable.gojo),
                            contentDescription = null,
                            modifier = Modifier.clip(CircleShape).size(42.dp)
                        )
                    }
                },
                backgroundColor = Color.White,
                contentColor = twitterBlack
            )
        },
        drawerContent = {
            if (scaffoldState.drawerState.isOpen){
                drawerContent()
            }

        }
    ) {

    }
}


@Composable
fun drawerContent(){
    Column(
        horizontalAlignment = Alignment.Start
    ){
        Column {
            Image(
                painter = painterResource(R.drawable.gojo),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape).size(50.dp)
            )
            Text(
                text = "Gojo Satoru",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "@gojo",
                style = MaterialTheme.typography.body2
            )
        }
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextIcon(
                icon = Icons.Outlined.Person,
                contentDescription = "",
                text = "Profile"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextIcon(
                icon = Icons.Outlined.Description,
                contentDescription = "",
                text = "Lists"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextIcon(
                icon = Icons.Outlined.Topic,
                contentDescription = "",
                text = "Topic"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextIcon(
                icon = Icons.Outlined.BookmarkBorder,
                contentDescription = "",
                text = "Bookmark"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextIcon(
                icon = Icons.Outlined.Bolt,
                contentDescription = "",
                text = "Moments"
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextIcon(
                icon = Icons.Outlined.Payments,
                contentDescription = "",
                text = "Monetization"
            )
        }
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Text(
                text = "Settings and Privacy"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Help Center"
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = Icons.Outlined.Lightbulb,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Outlined.QrCode,
                    contentDescription = "",
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun TwitterPreview(){
    ComposeUiTempletesTheme {
        TwitterClone()
    }
}
