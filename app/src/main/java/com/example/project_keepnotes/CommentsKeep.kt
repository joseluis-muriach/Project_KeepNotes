package com.example.project_keepnotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class CommentsKeep(
    var comment: String
)
fun getCommentsCoff(): List<CommentsKeep> {
    return listOf(
        CommentsKeep("Servicio algo flojo, aún así lo recomiendo"),
        CommentsKeep("Céntrica y acogedora. Volveremos seguro"),
        CommentsKeep("La ambientacion muy buena, pero en la planta de arriba un poco escasa."),
        CommentsKeep(
            "La comida estaba deliciosa y bastante bien de precio, mucha variedad de platos.\n" +
                    "El personal muy amable, nos permitieron ver todo el establecimiento.\n"
        ),
        CommentsKeep("Muy bueno"),
        CommentsKeep("Excelente. Destacable la extensa carta de cafés."),
        CommentsKeep("Buen ambiente y buen servicio. Lo recomiendo."),
        CommentsKeep("En días festivos demasiado tiempo de espera."),
        CommentsKeep("Los camareros/as no dan abasto."),
        CommentsKeep("No lo recomiendo."),
        CommentsKeep("No volveré."),
        CommentsKeep("Repetiremos."),
        CommentsKeep("Gran selección de tartas y cafés."),
        CommentsKeep(
            "La vajilla muy bonita todo de diseño que en el entorno del bar queda ideal." + "\n" +
                    "Puntos negativos: el servicio es muy lento y los precios son un poco elevados.",),
        CommentsKeep("Todo lo que he probado en la cafetería está riquísimo, dulce o salado.")
    )
}

@Composable
//Esto lo creamos para meter nuestra lista de comentarios en las cards
fun ItemComment(commentsKeep: CommentsKeep) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color(0xFFF5E892)) //El color de la card
    ) {
        Text(
            text = commentsKeep.comment,
            modifier = Modifier.padding(10.dp)
        )
    }
}
