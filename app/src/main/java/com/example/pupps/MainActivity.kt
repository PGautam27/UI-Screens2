package com.example.pupps

import android.app.Fragment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pupps.composable.SwipeCard
import com.example.pupps.percieverance.combosables.MyDay
import com.example.pupps.percieverance.components.Spotify
import com.example.pupps.percieverance.components.faceBookIcon
import com.example.pupps.percieverance.components.getGooglePhotosIcon
import com.example.pupps.percieverance.components.getWeatherApp
import com.example.pupps.ui.theme.PuppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                faceBookIcon()
//                Spacer(modifier = Modifier.padding(50.dp))
//                getGooglePhotosIcon()
//                Spacer(modifier = Modifier.padding(50.dp))
//                getWeatherApp()
//                Spotify()
//                Spacer(modifier = Modifier.padding(50.dp))
                SwipeCard()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppsTheme {
        Greeting("Android")
    }
}