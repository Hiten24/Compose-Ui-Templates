package com.example.composeuitemplates.presentation.twitter_clone

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TextIcon(
    icon: ImageVector,
    text: String,
    contentDescription: String=""
){
    Row{
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text=text,
            style = MaterialTheme.typography.body1
        )
    }
}