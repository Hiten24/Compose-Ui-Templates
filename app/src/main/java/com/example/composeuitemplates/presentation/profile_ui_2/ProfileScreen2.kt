package com.example.composeuitemplates.presentation.profile_ui_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.ui.theme.*

@Composable
fun ProfileScreen2(navController: NavController?) {
    ProfileScreenUI()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenUI() {

    Column(
        modifier = Modifier
            .background(color = Gray100)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp),
            backgroundColor = White,
            elevation = 5.dp
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(10.dp, bottom = 20.dp)
                    .background(color = White)
            ) {
                val (/*imgBack, imgMore, */imgProfile, txtMyProfile, txtUserName, txtBio, rowNumbers) = createRefs()

//                Image(
//                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24_black),
//                    contentDescription = "Back Arrow",
//                    modifier = Modifier
//                        .padding(bottom = 20.dp)
//                        .constrainAs(imgBack) {
//                            top.linkTo(parent.top)
//                            start.linkTo(parent.start)
//                        }
//                        .padding(top = 20.dp, start = 10.dp)
//                )
//
//                Image(
//                    painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
//                    contentDescription = "More Option",
//                    modifier = Modifier
//                        .constrainAs(imgMore) {
//                            top.linkTo(imgBack.top)
//                            bottom.linkTo(imgBack.bottom)
//                            end.linkTo(parent.end)
//                        }
//                        .padding(end = 15.dp)
//                )

                Text(
                    text = "My Profile",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .constrainAs(txtMyProfile) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .padding(start = 15.dp),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = DarkGray
                )

                Image(
                    painter = painterResource(id = R.drawable.gojo),
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .height(120.dp)
                        .width(120.dp)
                        .constrainAs(imgProfile) {
                            top.linkTo(txtMyProfile.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentDescription = "Profile Image"
                )

                Text(
                    text = "Pratik Fagadiya",
                    modifier = Modifier
                        .constrainAs(txtUserName) {
                            top.linkTo(imgProfile.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(top = 15.dp),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = DarkGray
                )

                Text(
                    text = "A Passionate Android Developer Who have lot of interest in mobile & new technologies",
                    modifier = Modifier
                        .padding(start = 5.dp, end = 5.dp)
                        .constrainAs(txtBio) {
                            top.linkTo(txtUserName.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .alpha(0.7f)
                        .padding(top = 15.dp, start = 20.dp, end = 20.dp),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    lineHeight = 23.sp,
                    letterSpacing = 1.sp,
                    color = DarkGray
                )

                Row(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .constrainAs(rowNumbers) {
                            top.linkTo(txtBio.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Photos",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            modifier = Modifier.alpha(0.6f)
                        )
                        Text(
                            text = "3",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = DarkGray
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Followers",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            modifier = Modifier.alpha(0.6f)
                        )
                        Text(
                            text = "10.2K",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = DarkGray
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Following",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = DarkGray,
                            modifier = Modifier.alpha(0.6f)
                        )
                        Text(
                            text = "139",
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = DarkGray
                        )
                    }
                }
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
        ) {
            val (post1, post2, post3) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.gojo),
                contentDescription = "Post 1",
                modifier = Modifier
                    .fillMaxWidth(0.48f)
                    .padding(5.dp)
                    .height(300.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .constrainAs(post1) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(post2.start)
                    }, contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.gojo),
                contentDescription = "Post 2",
                modifier = Modifier
                    .fillMaxWidth(0.48f)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .constrainAs(post2) {
                        top.linkTo(post1.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(post3.top)
                        start.linkTo(post1.end)
                        height = Dimension.fillToConstraints
                    }, contentScale = ContentScale.Crop

            )

            Image(
                painter = painterResource(id = R.drawable.gojo),
                contentDescription = "Post 2",
                modifier = Modifier
                    .fillMaxWidth(0.48f)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .constrainAs(post3) {
                        bottom.linkTo(post1.bottom)
                        top.linkTo(post2.bottom)
                        end.linkTo(post2.end)
                        start.linkTo(post2.start)
                        height = Dimension.fillToConstraints
                    },
                contentScale = ContentScale.Crop

            )

        }

    }
}