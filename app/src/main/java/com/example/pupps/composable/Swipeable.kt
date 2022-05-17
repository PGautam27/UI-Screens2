package com.example.pupps.composable

import android.media.Image
import android.os.Message
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.pupps.R

val list = listOf<friend>(
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
            friend(4,Icons.Filled.Person,"Gautam P", 20)
        )
    }
    LazyColumn(Modifier.fillMaxSize()){
        items(list1, {it.id!!}){ item->
            val dismissState = rememberDismissState(
                confirmStateChange = {
                   if (it == DismissValue.DismissedToEnd || it==DismissValue.DismissedToStart){
                       list1.remove(item)
                   }
                    true
                }
            )
            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                background = {},
                dismissContent = {
                    Card(
                        modifier = Modifier.fillMaxWidth(), elevation = animateDpAsState(
                            targetValue = if (dismissState.dismissDirection != null) 4.dp else 0.dp
                        ).value
                    ) {

                    }
                    friend(item.id,item.profileImage,item.name,item.age)
                }
            )
        }
    }
}