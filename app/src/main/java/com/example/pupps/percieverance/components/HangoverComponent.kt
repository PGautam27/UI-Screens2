package com.example.pupps.percieverance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HangOverComponent() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9B9B9B))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {

        val stateList = listOf<String>(
            "Mild","Moderate","Severe"
        )
        val state = listOf<String>(
            "Whole of Me", "Diagnostics"
        )
        var index by remember { mutableStateOf(0) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            stateList.forEachIndexed {  i, s ->
                Button(
                    onClick = { index = i },
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (index == i) Color(0xFFED746A) else Color.White,
                        contentColor = if (index == i ) Color.White else Color.Black
                    ),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(text = s)
                }
            }
        }

        Spacer(modifier = Modifier.padding(25.dp))
        
        TabRow(selectedTabIndex = index,
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            backgroundColor = Color.White,
            indicator = {},
            divider = {}
        ) {
            state.forEachIndexed{ i, s ->
                Button(
                    onClick = { index = i },
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (index == i) Color.Gray else Color.White,
                        contentColor = if (index == i ) Color.White else Color.Black
                    ),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(text = s)
                }
            }

        }
    }
}