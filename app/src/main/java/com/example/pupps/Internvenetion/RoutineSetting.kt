package com.example.pupps.Internvenetion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times

@Composable
fun SetupDay() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .height(LocalConfiguration.current.screenHeightDp.dp / 15)
        ) {
            Text(
                text = "MYDAY",
                fontWeight = FontWeight.Bold,
                fontSize = LocalConfiguration.current.fontScale.times(25).sp
            )
            Icon(imageVector = Icons.Default.List, contentDescription = null)
        }
        Box(
            modifier = Modifier
                .background(color = Color(0xFFd6d6d6))
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .padding(start = 50.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Goals",
                color = Color(0xFF4a4a4a),
                fontSize = LocalConfiguration.current.fontScale.times(25).sp
            )
        }
    }
}