package com.example.pupps.percieverance.combosables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R

@Composable
fun MyDay() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Text(text = "My Day", textAlign = TextAlign.Center, fontSize = 34.sp)
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)){
            item {
                Image(painter = painterResource(id = R.drawable.bed), contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "Scheduled", style = TextStyle(color = Color(0xFF9B9B9B), fontSize = 12.sp))
        Spacer(modifier = Modifier.height(2.dp))
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)){
            item {

            }
        }
    }
}