package com.example.friends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.friends.api.DAO
import com.example.friends.models.User
import com.example.friends.ui.theme.FriendsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            FriendsTheme {
////                // A surface container using the 'background' color from the theme
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colors.background
////                ) {
//////                    Greeting("Android")
////                }
//            }
            dao.getData()
            TopAppBarSample()
        }
    }
}
val dao = DAO()

@Composable
fun CardUser(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append(user.first_name + user.last_name)
                }
            )
        }
    }
}

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("Nome do Usuário")
                }
            )
        }
    }
}

@Composable
fun TopAppBarSample(){
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(
                    text = "Amigos",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            },
            backgroundColor = Color.Blue,
        )
        CardDemo()
        var listUsers: MutableList<User> = dao.getData()

        listUsers.forEach { user ->
            CardUser(user)
        }
    }
}