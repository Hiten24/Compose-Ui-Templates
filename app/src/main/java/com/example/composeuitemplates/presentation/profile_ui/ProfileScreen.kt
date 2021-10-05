package com.example.composeuitemplates.presentation.profile_ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.example.composeuitemplates.R
import com.example.composeuitemplates.ui.theme.ComposeUiTempletesTheme


@ExperimentalFoundationApi
@Composable
fun ProfileScreen(navController: NavController? = null) {
    val posts_list = listOf(
        Posts(
            "https://bit.ly/3AgPBVI",
            "gojo and itadori"
        ),
        Posts(
            "https://bit.ly/3oAIk0M",
            "domain expansion"
        ),
        Posts(
            "https://bit.ly/3AcqrYy",
            "gojo googles"
        ),
        Posts(
            "https://bit.ly/3BgosU6",
            "gojo"
        ),
        Posts(
            "https://bit.ly/3BdkZ97",
            "hanging around with friend"
        ),
        Posts(
            "https://bit.ly/3Acr702",
            "careless"
        ),
        Posts(
            "https://bit.ly/3mtCMT8",
            "young gojo"
        )
    )
    val tag_posts_list = listOf(
        Posts(
            "https://bit.ly/3abA6Uq",
            "gojo cosplay"
        ),
        Posts(
            "https://bit.ly/3DhIUEG",
            "gojo art"
        )
    )
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        Stats("Saturo Gojo", "10.1M", "100")
        Spacer(modifier = Modifier.height(16.dp))
        FeedComponent() {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostsComponent(
                posts_list = posts_list,
                modifier = Modifier.fillMaxWidth()
            )
            1 -> PostsComponent(
                posts_list = tag_posts_list,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .clickable(onClick = { })
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .align(Alignment.BottomStart)
                )
            }

            ProfileImage(
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }

}


@Composable
fun ProfileImage(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    Surface(
        color = Color(0xFF17181F),
        elevation = elevation,
        shape = RoundedCornerShape(40.dp),
        modifier = modifier,
        border = BorderStroke(
            3.dp,
            Brush.linearGradient(
                listOf(
                    Color(0xFFbc2a8d),
                    Color(0xFF8a3ab9)
                )
            )
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.gojo),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
fun Stats(
    username: String,
    followers: String,
    following: String
) {
    val name_list = listOf(
        "hitenn24",
        "dishant___gandhi"
    )

    val otherCount = 3
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = username,
            style = MaterialTheme.typography.h5,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed By ")
                name_list.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < name_list.size - 1) {
                        append(", ")
                    }
                }
                if (otherCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "7",
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.DarkGray
                )
                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Divider(
                modifier = Modifier.height(40.dp).width(1.dp).padding(top = 2.dp, bottom = 2.dp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = followers,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.DarkGray
                )
                Text(
                    text = "Followers",
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Divider(
                modifier = Modifier.height(40.dp).width(1.dp).padding(top = 2.dp, bottom = 2.dp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = following,
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.DarkGray
                )
                Text(
                    text = "Following",
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.LightGray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(
                colors = ButtonDefaults
                    .textButtonColors(
                        backgroundColor = Color(0xFFF94C84),
                        contentColor = Color.White
                    ),
                onClick = {},
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    "Follow"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(
                colors = ButtonDefaults
                    .textButtonColors(
                        backgroundColor = Color(0xFF2B2B2B),
                        contentColor = Color.White
                    ),
                onClick = {},
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    "Message"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }

    }
}


@Composable
fun FeedComponent(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val imageWithText = listOf(
        ImageWithText(
            image = painterResource(id = R.drawable.ic_grid),
            text = "Posts"
        ),
        ImageWithText(
            image = painterResource(id = R.drawable.ic_instagram_tag),
            text = "Tags"
        )
    )
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(18.dp)
                        .size(20.dp)
                )
            }
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun PostsComponent(
    posts_list: List<Posts>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f)
    ) {
        items(posts_list.size) {
            Image(
                painter = rememberImagePainter(
                    data = posts_list[it].imageUrl,
                    builder = {
                        crossfade(true)
                        placeholder(drawableResId = R.drawable.gojo)
                        scale(Scale.FILL)
                    }
                ),
                contentDescription = posts_list[it].text,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun ProfilePreview() {
    ComposeUiTempletesTheme {
        ProfileScreen()
    }
}