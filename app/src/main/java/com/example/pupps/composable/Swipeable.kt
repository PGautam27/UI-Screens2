package com.example.pupps.composable

import android.media.Image
import android.os.Message
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.pupps.R

var list = listOf<friend>(
    friend(1,Icons.Filled.Person,"Samuel", 20),
    friend(2,Icons.Filled.Person,"Pritam", 16),
    friend(3,Icons.Filled.Person,"Nigger Niranjan", 31),
    friend(4,Icons.Filled.Person,"Gautam P", 20)
)
data class friend(
    val id: Int,
    val profileImage: ImageVector,
    val name:String,
    val age:Int
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun swipe() {
    val list1 = remember {
        mutableStateListOf(
            friend(1,Icons.Filled.Person,"Samuel", 20),
            friend(2,Icons.Filled.Person,"Pritam", 16),
            friend(3,Icons.Filled.Person,"Nigger Niranjan", 31),
            friend(4,Icons.Filled.Person,"Gautam P", 20) ,
            friend(5,Icons.Filled.Person,"kd", 20),
            friend(6,Icons.Filled.Person,"yo", 16),
            friend(7,Icons.Filled.Person,"Nigger ", 31),
            friend(8,Icons.Filled.Person,"Gautam ", 20)
        )
    }

    var isSwipeRemoved by remember {
        mutableStateOf(false)
    }

    LazyColumn(Modifier.fillMaxSize()){
        items(list1, {it.id!!}){ item->
            val dismissState = rememberDismissState(
                confirmStateChange = {
                   if (it == DismissValue.DismissedToEnd || it==DismissValue.DismissedToStart){
                       list1.remove(item)
                       isSwipeRemoved = true
                   }
                    true
                }
            )

            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                dismissThresholds = {FractionalThreshold(0.2f)},
                background = {
                    val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
                    val color by animateColorAsState(
                        targetValue = when (dismissState.targetValue) {
                            DismissValue.Default-> Color.LightGray
                            DismissValue.DismissedToEnd -> Color.Green
                            DismissValue.DismissedToStart -> Color.Red
                        }
                    )
                    
                    val icon = when(direction){
                        DismissDirection.StartToEnd -> Icons.Default.Done
                        DismissDirection.EndToStart -> Icons.Default.Delete
                    }
                    val scale by animateFloatAsState(targetValue = if (dismissState.targetValue == DismissValue.Default) 0.8f else 1.2f)

                    val alignment = when(direction){
                        DismissDirection.EndToStart -> Alignment.CenterEnd
                        DismissDirection.StartToEnd -> Alignment.CenterStart
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color)
                            .padding(start = 12.dp, end = 12.dp),
                        contentAlignment = alignment
                    ){
                        Icon(icon, contentDescription = null, modifier = Modifier.scale(scale))
                    }
                },
                dismissContent = {
                    Card(
                        modifier = Modifier.fillMaxWidth(), elevation = animateDpAsState(
                            targetValue = if (dismissState.dismissDirection != null) 4.dp else 0.dp
                        ).value
                    ) {
                        Text(text = item.name)
                        Spacer(modifier = Modifier.padding(20.dp))
                        Text(text = "${item.age}")
//                        friend(item.id,item.profileImage,item.name,item.age)
                    }
                }
            )
        }
    }
}