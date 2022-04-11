package com.example.pupps.percieverance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun scheduledCard() {

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
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
        ) {
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
                modifier = Modifier.align(Alignment.TopCenter)
            )
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
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 5.dp)
            )
        }
    }
}