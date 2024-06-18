package com.example.painter.signature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun ComposePaint(modifier: Modifier = Modifier) {
    val paths = remember { mutableStateOf(mutableListOf<PathState>()) }
    Scaffold(
        topBar = {
            ComposePaintAppBar{
                paths.value =  mutableListOf()
            }
        }
    ) {
        PaintBody(paths)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposePaintAppBar(
    onDelete: () -> Unit
) {
    TopAppBar(
        title = {Text(text = "Compose Paint/Signature")},
        actions = {
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                )
            }
        }
    )
}

@Composable
fun PaintBody(
    paths: MutableState<MutableList<PathState>>
) {
    Box(modifier = Modifier.fillMaxSize()){
        val drawColor = remember { mutableStateOf(Color.Black) }
        val drawBrush = remember { mutableFloatStateOf(5f) }
        val usedColor = remember { mutableSetOf(Color.Black, Color.White, Color.Gray) }

        paths.value.add(PathState(Path(), drawColor.value, drawBrush.value))

        DrawingCanvas(
            drawColor,
            drawBrush,
            usedColor,
            paths.value
        )
        DrawingTools(
            drawColor = drawColor,
            drawBrush = drawBrush,
            usedColor = usedColor.value
        )
    }
}

@Composable
fun DrawingTools(drawColor: MutableState<Color>, drawBrush: MutableFloatState, usedColor: Any) {
    TODO("Not yet implemented")
}

@Composable
fun DrawingCanvas(drawColor: MutableState<Color>, drawBrush: MutableFloatState, usedColor: MutableSet<Color>, value: MutableList<PathState>) {

}
