package com.example.pupps.Animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.pupps.R

@Composable
fun TextAnimationComponent() {
    val text = buildAnnotatedString {
        append("Jetpack ")
        appendInlineContent("composeLogo", "Compose Logo")
        appendInlineContent("animatedText", "Animated Text")
    }

    val inlineContent = mapOf(
        "composeLogo" to InlineTextContent(
            placeholder = Placeholder(
                width = 2.em,
                height = 1.em,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            ),
            children = {
                ComposeLogoComponent()
            }
        ),
        "animatedText" to InlineTextContent(
            placeholder = Placeholder(
                width = 5.em,
                height = 35.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            ),
            children = {
                ColorChangingTextComponent()
            }
        )
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 35.sp
            ),
            inlineContent = inlineContent
        )
    }
}

@Composable
fun ComposeLogoComponent() {
    val image = ImageBitmap.imageResource(R.drawable.compose_logo)
    val infiniteTransition = rememberInfiniteTransition()

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween<Float>(
                durationMillis = 3000,
                easing = FastOutLinearInEasing,
            ),
        )
    )

//    Canvas(Modifier.size(48.dp)) {
//        rotate(rotation) {
//            drawImage(image)
//        }
//    }
}

@Composable
fun ColorChangingTextComponent() {

    val currentColor by remember { mutableStateOf(Color.Red) }
    val transition = updateTransition(currentColor)

    val color by transition.animateColor(label = "") { state ->
        when (state) {
            Color.Red -> Color.Green
            Color.Green -> Color.Blue
            Color.Blue -> Color.Red
            else -> Color.Red
        }
    }

    Text(
        text = "Compose",
        color = color,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 35.sp
        )
    )
}