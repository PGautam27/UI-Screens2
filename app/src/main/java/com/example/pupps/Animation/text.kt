package com.example.pupps.Animation

import androidx.compose.animation.core.*
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay

@Composable
fun textm() {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue =1.0f,
            animationSpec = tween(
                durationMillis = 5000,
                easing = LinearEasing
            )
        )
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "HI how are you my name is Bathely")

    }

}