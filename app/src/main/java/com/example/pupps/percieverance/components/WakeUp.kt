package com.example.pupps.percieverance.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun WakeUp() {

    Box(
        modifier = Modifier
            .height(100.dp)
            .width(140.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.play),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 10.dp)
                    .clickable { }
            )
            Image(painter = painterResource(id = R.drawable.time),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 70.dp)
                    .width(23.dp)
                    .height(23.dp)
                    .padding(top = 4.dp)
                    .clickable { }
            )
        }
        Text(
            AnnotatedString(text = "Wake Up", spanStyle = SpanStyle(fontSize = 16.sp)).plus(
                AnnotatedString("\nRoutine", spanStyle = SpanStyle(fontSize = 14.sp))
            ), modifier = Modifier
                .align(
                    Alignment.BottomStart
                )
                .padding(10.dp)
        )
    }

}



