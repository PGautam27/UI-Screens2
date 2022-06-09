package com.example.pupps.Internvenetion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R

data class HabitList(
    val image: Int,
    val descript: String
)

@Composable
fun habitTask() {
    val timesOfDay = listOf("Morning","Evening","Night","Workout")
    val morningList = listOf(
        HabitList(R.drawable.pupp, "Walk the dog"),
        HabitList(R.drawable.pupp, "Gratitude Journal"),
        HabitList(R.drawable.pupp, "Make Bed"),
        HabitList(R.drawable.pupp, "Meditate"),
        HabitList(R.drawable.pupp, "Shower"),
        HabitList(R.drawable.pupp, "Reading"),
    )
    val eveningList = listOf(
        HabitList(R.drawable.pupp, "Walk the dog"),
        HabitList(R.drawable.pupp, "Gratitude Journal"),
        HabitList(R.drawable.pupp, "Make Bed"),
        HabitList(R.drawable.pupp, "Shower"),
    )
    val nightList = listOf(
        HabitList(R.drawable.pupp, "Walk the dog"),
        HabitList(R.drawable.pupp, "Gratitude Journal"),
        HabitList(R.drawable.pupp, "Make Bed"),
        HabitList(R.drawable.pupp, "Meditate"),
        HabitList(R.drawable.pupp, "Shower"),
    )
    val workoutList = listOf(
        HabitList(R.drawable.pupp, "Gratitude Journal"),
        HabitList(R.drawable.pupp, "Shower"),
        HabitList(R.drawable.pupp, "Reading"),
    )
    val timeList = listOf(morningList,eveningList,nightList,workoutList)
    val holdIndexes = remember {
        mutableStateOf(listOf(-1))
    }
    var indexs by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Habit List",
            style = TextStyle(color = Color(0xFFb1b1b1), fontSize = 16.sp),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 10.dp, vertical = 15.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 40.dp)
        ) {
            timesOfDay.forEachIndexed { index, s -> 
                TextButton(onClick = { indexs = index }, colors = ButtonDefaults.textButtonColors(
                    contentColor = if (indexs == index) Color.Black else Color(0xFFb1b1b1)
                )) {
                    Text(text = s, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        timeList.forEachIndexed{ i, list ->
            if (i == indexs){
                list.forEachIndexed { i, s ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color(0x80dddddd))
                            .width(LocalConfiguration.current.screenWidthDp.dp - 40.dp)
                            .height(LocalConfiguration.current.screenHeightDp.dp / 13)
                    ) {
                        Image(painter = painterResource(id = s.image), contentDescription = null, modifier = Modifier
                            .size(45.dp)
                            .padding(start = 20.dp) )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(text = s.descript, fontWeight = FontWeight.Bold, fontSize = 15.sp,modifier = Modifier.padding(start = 10.dp))
                            RadioButton(
                                selected = holdIndexes.value.contains(i),
                                onClick = {
                                    holdIndexes.value = holdIndexes.value + i
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
        ), elevation = ButtonDefaults.elevation(0.dp), modifier = Modifier
            .border(
                1.dp, color = Color.Black,
                RoundedCornerShape(30.dp)
            )
            .width(100.dp)
            .height(50.dp)) {
            Text(text = "Save", fontSize = 20.sp, color = Color.Black)
        }
    }
}