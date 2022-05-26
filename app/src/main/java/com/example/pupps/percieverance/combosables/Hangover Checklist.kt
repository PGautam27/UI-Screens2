package com.example.pupps.percieverance.combosables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class item(
    val title : String,
    val category : String,
    val isChecked : Boolean
)
var list = listOf(
    item("A", "Vitamin C 1000 mg", false),
    item("A", "Vitamin B12 500 mg", false),
    item("B", "Coconut Water", false),
    item("C", "Sports Drink", false),
    item("D", "Pink Salt", false),
)
@Composable
fun hangOverChecklist() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp),
        verticalArrangement = Arrangement.Top,
        Alignment.Start
    ) {
        Text(
            text = "Hangover Checklist",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp),
            modifier = Modifier.padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Column(modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color.Gray)
            .size(60.dp)
            .clickable { }, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Box(modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .size(20.dp)
                .background(color = Color.White))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "The indicator is a signal of your preparedness for the journey. Use this checklist to get ready for the hangover journey.",
        )
        Spacer(modifier = Modifier.padding(10.dp))
        list.forEachIndexed { index, item ->
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0x80E0E0E0))
                    .height(50.dp)
                    .width(LocalConfiguration.current.screenWidthDp.dp - 40.dp)
            ) {
                Text(text = item.category, modifier = Modifier.padding(10.dp))
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .size(20.dp)
                    .background(color = Color.White)
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }
        Spacer(modifier = Modifier.padding(90.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterHorizontally).clip(RoundedCornerShape(20.dp)), colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFedf1fc), contentColor = Color(0xff4c78db)
        )) {
            Text(text = "Save")
        }
    }
}