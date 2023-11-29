package com.example.project_keepnotes

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTopBar() {
    //Necesitamos todo esto para crear la campana infinita
    val value by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 25f,
        targetValue = -25f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )//Hasta aqui

    //La columna la he creado para poder crear el divider en zona de abajo, no de arriba
    Column {
        //La top bar siempre va en el Scaffol que lo pondremos en nuestra pantalla principal, no en el MAIN
        TopAppBar(
            //Siempre pondremos el titulo primero y luego lo demas
            title = {
                Text(
                    text = "KeepNotes",
                    color = Color.White
                )
            },
            //Aquí ponemos el color de la topAppBar, que en este caso será transparente
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent),
            navigationIcon = { //Aquí pondremos el botton que queramos que haga la acción
                IconButton(onClick = { /*TODO*/ }) { //En el onclick, en este caso no hará nada
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            },
            actions = { //Para poner los tres puntos o cualquier icono a la derecha
                //Icono para crear la campana infinita
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "campana",
                    modifier = Modifier
                        .graphicsLayer(
                            transformOrigin = TransformOrigin(
                                pivotFractionX = 0.5f,
                                pivotFractionY = 0.0f,
                            ),
                            rotationZ = value
                        ),
                    tint = Color.White
                )

                //Variable la cual la creamos por que en el MoreVert tenemos varias opciones
                var showMenu by remember { mutableStateOf(false) }
                //Haciendo click el lambda cambia de false a true o viceversa
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Desplegable de dos opciones",
                        tint = Color.White
                    )
                }
                //Creamos el drop menu por que tenemos varias opciones dentro de MoreVert
                DropdownMenu(
                    expanded = showMenu, //Controla si el menu está expandido o no
                    //Un lambda que se ejecuta cuando el usuario cierra el menú
                    onDismissRequest = { showMenu = false },
                    //Modificador que establece el ancho del menú desplegable
                    Modifier.width(150.dp)
                ) {
                    DropdownMenuItem( //Esta línea crea un elemento de menú desplegable
                        text = { Text(text = "Compartir") },
                        onClick = { /*TODO*/ }, //No queremos que haga nada
                        leadingIcon = { //Un icono que se muestra antes del texto del elemento
                            Icon(
                                imageVector = Icons.Filled.Share,
                                contentDescription = "share"
                            )
                        }
                    )
                    DropdownMenuItem( //Por cada icono tenemos que hacer un DropdownMenu
                        text = { Text(text = "Album") },
                        onClick = { /*TODO*/ },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.AccountBox,
                                contentDescription = "share"
                            )
                        }
                    )
                }
            }
        )
        //La línea negra que esta debajo de la topAppBar
        Divider(
            color = Color.Black,
            thickness = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                //.padding(start = 16.dp, end = 16.dp)
        )
    }
}