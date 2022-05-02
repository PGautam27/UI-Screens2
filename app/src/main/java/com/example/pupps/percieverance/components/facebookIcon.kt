package com.example.pupps.percieverance.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun faceBookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
    }
    Canvas(modifier = Modifier.size(100.dp).padding(16.dp)){
        drawRoundRect(
            color = Color(0xff1778d1),
            cornerRadius = CornerRadius(20f,20f)
        )
        drawContext.canvas.nativeCanvas.drawText("f",center.x + 25,center.y + 90, paint)
    }
}