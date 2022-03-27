package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.ui.theme.*
import kotlinx.coroutines.launch


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


@Composable
fun TwitterClone(navController: NavController?=null){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_twitter),
                            contentDescription = null,
                            modifier = Modifier.size(42.dp),
                            tint = twitterBlue
                        )
                    }

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
                contentColor = twitterBlack,
                modifier = Modifier.fillMaxWidth().padding(6.dp),
                actions = {

                    Icon(
                        imageVector = Icons.Outlined.AutoAwesome,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                elevation = 0.dp
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
        Text(
            text = "Account Center",
            style = TextStyle(
                color = twitterBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(8.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
//            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(R.drawable.gojo),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape).size(40.dp)
            )
            Text(
                text = "Gojo Satoru",
                style = TextStyle(
                    color = twitterBlack,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "@gojo",
                style = TextStyle(
                    color = twitterDarkGray,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text="5",
                    style = TextStyle(
                        color = twitterBlack,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Following",
                    style = TextStyle(
                        color = twitterDarkGray,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "1M",
                    style = TextStyle(
                        color = twitterBlack,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Followers",
                    style = TextStyle(
                        color = twitterDarkGray,
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp
                    )
                )

            }
        }
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            items(menuList){ menuItem ->
                Spacer(modifier = Modifier.height(8.dp))
                TextIcon(
                    icon = menuItem.icon,
                    contentDescription = menuItem.text,
                    text = menuItem.text
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Divider()
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Settings and Privacy",
                style = MaterialTheme.typography.body1,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Help Center",
                style = MaterialTheme.typography.body1,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Outlined.Lightbulb,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Icon(
                imageVector = Icons.Outlined.QrCode,
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
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
