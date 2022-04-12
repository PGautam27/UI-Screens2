package com.example.pupps.percieverance.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pupps.R

@Composable
fun Cog() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.cog), contentDescription = null, modifier = Modifier.height(135.dp).width(120.dp))
            Image(painter = painterResource(id = R.drawable.cog), contentDescription = null, modifier = Modifier.height(135.dp).width(120.dp).padding(start = 200.dp, top = 10.dp))

        }
    }
}