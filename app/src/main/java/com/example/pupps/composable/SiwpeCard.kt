package com.example.pupps.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeCard() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Swipe Left Or Right")
                },
                navigationIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            Icons.Outlined.Menu,
                            contentDescription = "Navigation Menu"
                        )
                    }
                }
            )
        }
    ) {
        Column {
            LazyColumn(
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(20) { index ->
                    SwipeLeftRight(index)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun SwipeLeftRight(index: Int) {
    val squareSize = 60.dp
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1, -sizePx to 2)
    val openDialog = remember { mutableStateOf(false) }
    val text = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
         AlertDialogs(openDialog = openDialog, text = text.value)

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(end = 10.dp, top = 10.dp, start = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.primary)
                    .swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ ->
                            FractionalThreshold(1.0f)
                        },
                        orientation = Orientation.Horizontal
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {
                            openDialog.value = true
                            text.value = "Do you want to edit item ${index + 1}"
                        },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Edit",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    IconButton(
                        onClick = {
                            openDialog.value = true
                            text.value = "Do you want to delete item ${index + 1}"
                        },
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Delete",
                            tint = Color.White
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                swipeableState.offset.value.roundToInt(), 0
                            )
                        }
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(10.dp))
                        .align(Alignment.CenterStart)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = 5.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(MaterialTheme.colors.background),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Make it Easy ${index + 1}",
                                color = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AlertDialogs(
    openDialog: MutableState<Boolean>,
    text: String
) {
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(
                    text = "Alert Dialog!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(text = text)
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            openDialog.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        )
    }
}