package com.example.pupps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pupps.composable.Analysis
import com.example.pupps.percieverance.combosables.MyDay
import com.example.pupps.percieverance.components.Cog
import com.example.pupps.percieverance.components.WakeUp
import com.example.pupps.percieverance.components.scheduledCard
import com.example.pupps.ui.theme.PuppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppsTheme {
                MyDay()
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