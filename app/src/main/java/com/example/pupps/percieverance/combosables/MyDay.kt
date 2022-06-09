package com.example.pupps.percieverance.combosables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.example.pupps.percieverance.components.WakeUp
import com.example.pupps.percieverance.components.scheduledCard

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
                        painter = painterResource(id = R.drawable.routinebox),
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
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(20.dp))
            WakeUp()
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Scheduled", style = TextStyle(color = Color(0xFF9B9B9B), fontSize = 12.sp), textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(20.dp))
            scheduledCard()
            Spacer(modifier = Modifier.width(15.dp))
            scheduledCard()
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Co demand", style = TextStyle(color = Color(0xFF9B9B9B), fontSize = 12.sp), textAlign = TextAlign.Start)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(20.dp))
            scheduledCard()
            Spacer(modifier = Modifier.width(15.dp))
            scheduledCard()
        }
    }
}