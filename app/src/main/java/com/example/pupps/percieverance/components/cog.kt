package com.example.pupps.percieverance.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R
import com.google.accompanist.flowlayout.*
import com.google.android.material.internal.FlowLayout

@Composable
fun Cog() {

    val verticalScroll = rememberScrollState()
    val count = remember {
        mutableStateOf(1)
    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFEDF0F7)
            )
            .verticalScroll(verticalScroll)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.img), contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Let us know", fontSize = 34.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(1.dp))
            Text(text = "Choose your area of interest", style = TextStyle(fontSize = 16.sp, color = Color(0xFF989898)))
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            mainAxisSpacing = 20.dp,
            crossAxisAlignment = FlowCrossAxisAlignment.Center,
            mainAxisAlignment = MainAxisAlignment.Center,
            crossAxisSpacing = 20.dp
        ) {

            repeat(14){
                    if(it == count.value){
                        Image(painter = painterResource(id = R.drawable.cog), contentDescription = null, modifier = Modifier.padding(top = 30.dp))
                        count.value = count.value + 3
                    }
                    else
                        Image(painter = painterResource(id = R.drawable.cog), contentDescription = null)
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .height(65.dp)
            .width(350.dp)
            .clip(RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF4C78DB)
            )
        ) {
            Text(text = "Continue", fontSize = 24.sp, style = TextStyle(Color.White))
        }
        Spacer(modifier = Modifier.height(20.dp))
    }

}