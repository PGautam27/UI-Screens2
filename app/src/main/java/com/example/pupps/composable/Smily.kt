package com.example.pupps.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

data class smilely(
    val name : String,
    val value : Int
)

val list1 = listOf(
    smilely("Normal",0x1F642),
    smilely("Neutral",0x1F610),
    smilely("Good Smile", 0x1F601)
)
@Composable
fun Smiley() {

    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        list1.forEachIndexed{ index,it ->
            Text(text = String(Character.toChars(it.value)), fontSize = if (index == sliderPosition.toInt()) 50.sp else 30.sp)
        }
    }
    Slider(value = sliderPosition, onValueChange = {sliderPosition = it}, valueRange = 0f..3f, modifier = Modifier.fillMaxWidth(.8f))

}







//                Canvas(modifier = Modifier.size(100.dp)){
//                    val canvasHeight = size.height
//                    drawIntoCanvas { canvas ->
//                        canvas.nativeCanvas.drawText(
//                            String(Character.toChars(it.value)),
//                            offset ,
//                            (canvasHeight / 2) + 16f,
//                            Paint().asFrameworkPaint().apply {
//                                textSize = if (index == holdIndexValue.value) 200f else 150f
//                            }
//
//                        )
//                    }
//               }
//Text(text = "${floor(sliderPosition*10).toInt()}")

//var offset by remember { mutableStateOf(10f) }