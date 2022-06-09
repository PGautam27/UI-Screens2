package com.example.pupps.Internvenetion

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetupDay() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .height(LocalConfiguration.current.screenHeightDp.dp / 35)
        ) {
            Text(
                text = "MYDAY",
                fontWeight = FontWeight.Bold,
                fontSize = LocalConfiguration.current.fontScale.times(25).sp
            )
            Icon(imageVector = Icons.Default.List, contentDescription = null)
        }
    }
}