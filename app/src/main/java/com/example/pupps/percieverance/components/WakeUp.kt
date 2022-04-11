package com.example.pupps.percieverance.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R

@Composable
fun scheduledCard() {
    val textVisibility = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xBCF6F6F6)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(90.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
        ) {
            if (textVisibility.value){
                Text(
                    text = AnnotatedString(
                        text = "Bed Time",
                        spanStyle = SpanStyle(fontSize = 14.sp)
                    ).plus(
                        AnnotatedString(
                            text = "\nRoutine Flow",
                            spanStyle = SpanStyle(fontSize = 12.sp)
                        )
                    ),
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 5.dp)
                )
            }
            if (!textVisibility.value){
                Image(painter = painterResource(id = R.drawable.bed), contentDescription = null, modifier = Modifier
                    .width(200.dp)
                    .height(85.dp)
                    .align(Alignment.TopCenter)
                    .clickable { textVisibility.value = true}
                )
            }
            if (!textVisibility.value){
                Text(
                    text = AnnotatedString(
                        text = "Bed Time",
                        spanStyle = SpanStyle(fontSize = 14.sp)
                    ).plus(
                        AnnotatedString(
                            text = "\n\tRoutine",
                            spanStyle = SpanStyle(fontSize = 12.sp)
                        )
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 7.dp)
                )
            }

            if (textVisibility.value){
                Image(painter = painterResource(id = R.drawable.bed), contentDescription = null, modifier = Modifier
                    .width(200.dp)
                    .height(75.dp)
                    .align(Alignment.BottomCenter)
                    .clickable {textVisibility.value = false }
                )
            }
        }
    }
}