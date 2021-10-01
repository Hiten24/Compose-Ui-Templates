package com.example.composeuitemplates.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuitemplates.R

data class Chat(
    val message: String,
    val time: String
)

val message = mutableStateOf("")

val chats = mutableStateListOf<Chat>()

const val username = "Hiten Chawda"
const val profile = R.drawable.with_mask
const val isOnline = true

@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBarSection(
            username = username,
            profile = painterResource(id = profile),
            isOnline = isOnline
        )
        ChatSection(Modifier.weight(1f))
        MessageSection()
    }
}

@Composable
fun TopBarSection(
    username: String,
    profile: Painter,
    isOnline: Boolean,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = Color(0xFFFAFAFA),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = profile,
                contentDescription = null,
                modifier = Modifier.size(42.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(text = username, fontWeight = FontWeight.SemiBold)
                Text(
                    text = if (isOnline) "Online" else "Offline",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun ChatSection(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(chats) { chat ->
            MessageItem(
                chat.message,
                chat.time,
                true
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MessageSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface, shape = RoundedCornerShape(25.dp))
                    .height(50.dp)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = message.value,
                    onValueChange = {
                        message.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null,
                Modifier.clickable {
                    chats.add(Chat(message.value, "10:00 PM"))
                    message.value = ""
                }
            )
        }
    }
}

@Composable
fun MessageItem(
    messageText: String,
    time: String,
    isOut: Boolean
) {
    Column {
        Box(
            modifier = Modifier
                .background(
                    MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            Text(
                text = messageText,
                color = Color.White
            )
        }

        Text(
            text = time,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}