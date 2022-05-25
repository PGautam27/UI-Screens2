package com.example.pupps.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun bottomsheet( ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello buddy I am a bottom sheet")
        Text(text = "I am inside that one bob")
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "alhdg;akljhd;lkajdglkjasdlgkja;lskdjfa;lksdfjkkdjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjlakdj;lakjdf;lkajdf;lkajsdf;lkjasdfjal;skdfja;lsdkf" +
                "akljf;lakjdfl;kja;dlkfja;lksdjfl;akjdsflkajdf;lkjasd;lfkjal;skdfjla;kdsjflaksjdf;akdjf;alkjdff;akljsdf;klajsdffl;kjasdf;kljsad;lfkjas;lkdjfakldjf;akdjf" +
                "kjfa;lkjdf;lkajdffd;askjdf;laksjdf;lkajdsf;kasdgdjhsadgjwoir;akjf;lkjfijw;oeij;ldkjf;lakjdsflkjfdfl;kjsdfkljkdj dkjflkjsdflkajdfslfkjwoijekdsjaflkj kdjflaksdjflkajsflkajflkj" +
                "ajdl;jwoirjaksjflslkjeoijtkjdfflajsfoijwoiejrlakdfjoaisjfowijoiawjflkadfjlaksdfja;oseirjoawieroaiefjefkajfdalweijowaijoaiefwaouwer9awfh")
    }
}

@ExperimentalMaterialApi
@Composable
private fun Content(
    coroutineScope: CoroutineScope,
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    sheetState: ModalBottomSheetState,
    modifier: Modifier = Modifier
) {
    ModalBottomSheetLayout(
        modifier = modifier.fillMaxSize(),
        sheetState = sheetState,
        sheetBackgroundColor = MaterialTheme.colors.background,
        sheetContent = {
            Box(modifier.defaultMinSize(minHeight = 1.dp)){

            }
        }
    ) {
        Column(modifier.fillMaxSize()) {
            Button(onClick = { if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                coroutineScope.launch {
                    bottomSheetScaffoldState.bottomSheetState.expand()
                }
            }else {
                coroutineScope.launch{
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }}, modifier = modifier.fillMaxWidth()) {
                Text(text = "Bottom Sheet")
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomSheetDrawer() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    BottomSheetScaffold(
        sheetContent ={
                                      bottomsheet()
    }, drawerBackgroundColor = Color.Black,
        content = {
//        Box(){
//            Content(coroutineScope = coroutineScope, bottomSheetScaffoldState = bottomSheetScaffoldState, sheetState = sheetState)
//        }
    },
        sheetShape = (if (sheetState.isAnimationRunning || sheetState.isVisible){
            RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
        }else{
            RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
        }) as Shape,
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = if (sheetState.isAnimationRunning || sheetState.isVisible) 0.dp else 100.dp,
    )
}