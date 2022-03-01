package com.example.pupps.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R
import com.example.pupps.color.Colors

@Composable
fun Analysis() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.analysing),
            contentDescription = null,
            modifier = Modifier
                .height(315.dp)
                .width(315.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Analysing...",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Medium)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Please wait while we analyse your responses Assess your Readiness…",
            maxLines = 2,
            modifier = Modifier.padding(start = 30.dp, end = 30.dp),
            style = TextStyle(fontSize = 16.sp,color = Colors.grey),textAlign = TextAlign.Center
        )
    }
}