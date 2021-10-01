package com.example.composeuitemplates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.composeuitemplates.presentation.ChatScreen
import com.example.composeuitemplates.ui.theme.ComposeUiTempletesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiTempletesTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ChatScreen()
                }
            }
        }
    }
}