package com.example.pupps.Internvenetion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pupps.R
import me.bytebeats.views.charts.pie.PieChart
import me.bytebeats.views.charts.pie.PieChartData
import me.bytebeats.views.charts.pie.render.SimpleSliceDrawer

data class routines(
    val img : Int,
    val RoutineName : String,
    val timing : String,
    val timeOfTheDay : String
)


@Composable
fun SetupDay() {
    val list = listOf(
        routines(R.drawable.wakeup,"Wakeup","6:30","AM"),
        routines(R.drawable.food,"Breakfast","8:30","AM"),
        routines(R.drawable.workout,"Workout","7:30","PM"),
        routines(R.drawable.sleep,"Bed Time","9:30","PM")
    )
    Column( modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 5.dp)
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 40.dp
                )
                .height(LocalConfiguration.current.screenHeightDp.dp / 15)
        ) {
            Text(
                text = "MYDAY",
                fontWeight = FontWeight.Bold,
                fontSize = LocalConfiguration.current.fontScale.times(25).sp
            )
            Icon(imageVector = Icons.Default.List, contentDescription = null)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(start = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color(0x80d6d6d6))
                    .width(150.dp)
                    .height(100.dp),
                verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Goals",
                    color = Color(0xFF4a4a4a),
                    fontSize = LocalConfiguration.current.fontScale.times(11).sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxHeight()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFF48b951))
                            )
                            Text(text = "8 hrs", style = TextStyle(fontSize = 16.sp, color = Color(0xFF4a4a4a)))
                            Text(text = "Sleep", style = TextStyle(fontSize = 12.sp, color = Color(0xFF919191)))
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(6.dp))
        Window("Feeding Window", Color(0xFFd3e4ff),Color(0xFF8dacde), "14 hrs",0.55f)
        Spacer(modifier = Modifier.padding(5.dp))
        Window(text = "Fasting Window", hrs = "10 hrs", fillColor = Color(0xFFff8383), bgColor = Color(0xFFffc9c9), progress = 0.7f)
        Spacer(modifier = Modifier.padding(5.dp))
        pie()
        Spacer(modifier = Modifier.padding(50.dp))
        Text(
            text = "MyDay Routines",
            fontSize = 12.sp,
            color = Color(0xFF9f9f9f),
            modifier = Modifier
                .padding(start = 20.dp, bottom = 7.dp)
                .align(Alignment.Start)
        )
        list.forEachIndexed { i, s ->
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = Color(0x80dddddd))
                    .width(LocalConfiguration.current.screenWidthDp.dp - 40.dp)
                    .height(LocalConfiguration.current.screenHeightDp.dp / 13)
            ) {
                Image(painter = painterResource(id = s.img), contentDescription = null, modifier = Modifier
                    .width(55.dp)
                    .height(45.dp)
                    .padding(start = 10.dp) )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = s.RoutineName, fontWeight = FontWeight.Bold, fontSize = 15.sp,modifier = Modifier.padding(start = 10.dp))
                    Text(AnnotatedString(text = s.timing+" ", spanStyle = SpanStyle(fontSize = 15.sp)).plus(
                        AnnotatedString(text = s.timeOfTheDay, spanStyle = SpanStyle(fontSize = 15.sp))
                    ), modifier = Modifier.padding(end = 10.dp))
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
        }

    }
}

@Composable
fun Window(text:String, bgColor: Color,fillColor:Color,hrs:String,progress: Float) {
    Row(modifier = Modifier
        .width(LocalConfiguration.current.screenWidthDp.dp - 60.dp)
        .height(30.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(fillColor)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = text, fontSize = 12.sp)
            Text(text = hrs, fontSize = 12.sp)
        }
    }
    LinearProgressIndicator(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(LocalConfiguration.current.screenWidthDp.dp - 60.dp)
            .height(8.dp),
        progress = progress,
        backgroundColor = bgColor,
        color = fillColor,
    )
}

@Composable
fun pie() {
    Row(modifier = Modifier
        .width(LocalConfiguration.current.screenWidthDp.dp - 60.dp)
        .height(100.dp)) {
        Box(
            modifier = Modifier
                .padding(top = 2.dp)
                .size(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(0xFF799dff))
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            AnnotatedString(text = "Sleep Time\n", spanStyle = SpanStyle(fontSize = 12.sp)).plus(
                AnnotatedString(text = "8:30 hrs", spanStyle = SpanStyle(fontSize = 12.sp))
            )
        )
            PieChart(
                pieChartData = PieChartData(
                    slices = listOf(
                        PieChartData.Slice(
                            0.32f,
                            Color(0xFF799dff)
                        ),
                        PieChartData.Slice(
                            0.68f,
                            Color(0x80799dff)
                        )
                    ),
                ),
                sliceDrawer = SimpleSliceDrawer(sliceThickness = 100F),
                modifier = Modifier.size(100.dp)
            )
    }
}
