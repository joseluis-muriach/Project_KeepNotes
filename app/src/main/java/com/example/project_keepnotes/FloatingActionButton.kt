package com.example.project_keepnotes

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun FloatingButton(){
    //Esta variable es necesaria para hacer un floating con borde de color
    val value by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        ), label = ""
    )

    val colors = listOf(
        Color(0xFFBB00EE),
        Color(0xFFFCDB05),
        Color(0xFF0384F3),
        )
    var gradientBrush by remember { mutableStateOf(
            Brush.horizontalGradient(
                colors = colors,
                startX = -10.0f,
                endX = 400.0f,
                tileMode = TileMode.Repeated
            )
        )
    }
    //Hasta aqui

    FloatingActionButton(
        onClick = {
            //navController.navigate("CoverTypesOfFaces")
            // Handle click action here
            // For example, show a snackbar
            // SnackbarHostState.current.showSnackbar("FAB Clicked")
        },
        modifier = Modifier
            .padding(16.dp)
            //Esto nos hace falta para poner el borde de color
            .drawBehind {
                rotate(value) {
                    drawCircle(
                        gradientBrush, style = Stroke(width = 12.dp.value)
                    )
                }
            },//Hasta aquí
        containerColor = Color(0xFF6E47FD),
        //Hacemos el floating redondo
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.Create,
            contentDescription = null,
            tint = Color.White
        )
    }
}