package com.example.pupps.Internvenetion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R

@Composable
fun Routine() {
    Scaffold(
            topBar = {
                TopAppBar(backgroundColor = Color.White){
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Home", color = Color.Black)
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Settings", color = Color.Black)
                            }
                        }
                    }
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Spacer(modifier = Modifier.height(1.dp))
                Text(AnnotatedString(text = "Routine\n", spanStyle = SpanStyle(fontSize = 30.sp, fontWeight = FontWeight.Normal)).plus(
                    AnnotatedString(text = "Wake - Up", spanStyle = SpanStyle(fontSize = 35.sp, fontWeight = FontWeight.Bold))
                ))
                Image(painter = painterResource(id = R.drawable.routine_img), contentDescription = null)
//                Spacer(modifier = Modifier.padding(1.dp))
            }
        }
    }
}