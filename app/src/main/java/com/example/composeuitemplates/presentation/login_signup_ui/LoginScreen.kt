package com.example.composeuitemplates.presentation.login_signup_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composeuitemplates.R
import com.example.composeuitemplates.mainscreen.Screen
import com.example.composeuitemplates.presentation.login_signup_ui.components.*
import com.example.composeuitemplates.presentation.login_signup_ui.data.textWhite

@Composable
fun LoginScreen(
    navController: NavController? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            BackButton(R.drawable.ic_round_arrow_back, null) {
                navController?.navigateUp()
            }
            Spacer(modifier = Modifier.height(32.dp))
            TitleSection("Welcome\nBack", "Login to your account using email")
        }
        LoginSection("Email address", "Password")
        ContinueButtonSection("Login", R.drawable.ic_round_arrow_forward, null)
        OtherOptionSection()
        RedirectSection("Sign up", true) { navController?.navigate(Screen.SignupScreen.route) }
    }
}

@Composable
fun LoginSection(
    hintEmail: String,
    hintPassword: String
) {
    Column {
        SignupTextField(email.value, { email.value = it }, "",hintEmail)
        Spacer(modifier = Modifier.height(12.dp))
        SignupTextField(password.value, { password.value = it } ,"",hintPassword)
    }
}

@Composable
fun OtherOptionSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
       OptionItem(R.drawable.google, null)
       OptionItem(R.drawable.apple, null)
       OptionItem(R.drawable.facebook, null)
    }
}

@Composable
fun OptionItem(
    icon: Int,
    iconDescription: String?
) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(2.dp, textWhite, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = iconDescription,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen()
}