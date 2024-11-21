package com.example.whatsappejercicio_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.whatsappejercicio_1.Navegacion.AppNavigation
import com.example.whatsappejercicio_1.Navegacion.AppScreen
import com.example.whatsappejercicio_1.ui.theme.WhatsAppEjercicio_1Theme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            WhatsAppEjercicio_1Theme {
//
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    val navController = rememberNavController()
//
//                    FinalWhatsApp(
//                        modifier = Modifier.padding(innerPadding),
//                        navController = navController
//
//                    )
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}


@Composable
fun FinalWhatsApp(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Barra de iconos superior
        Row {
            Icon(
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color(0xFF222222), CircleShape)
                    .padding(4.dp),
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = "Menú",
                tint = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color(0xFF222222), CircleShape)
                    .padding(4.dp),
                imageVector = Icons.Rounded.Call,
                contentDescription = "Camara",
                tint = Color.White
            )
            Icon(
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color(0xFF25D366), CircleShape)
                    .padding(4.dp),
                imageVector = Icons.Rounded.Add,
                contentDescription = "Agregar nuevo chat",
                tint = Color.Black
            )
        }

        // Título "Chats"
        Text(
            text = "Chats",
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(19.dp),
            color = Color.White
        )

        // Campo de búsqueda
        // Lista de mensajes simulada
        var searchText by remember { mutableStateOf("") }
        val messages = listOf(
            R.string.contacto2,
            R.string.contacto3,
            R.string.contacto4,
            R.string.contacto5,
            R.string.contacto6,
            R.string.contacto7,
            R.string.contacto8,
            R.string.contacto9,
            R.string.contacto10,
            R.string.contacto11,
            R.string.contacto12,
            R.string.contacto13,
            R.string.contacto14,
            R.string.contacto15,
            R.string.contacto16,
            R.string.contacto17,
            R.string.contacto18,
            R.string.contacto19,
            R.string.contacto20
        )

        Box(
            modifier = Modifier
                .width(350.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color(0xFF222222), CircleShape)
                .padding(start = 15.dp, top = 5.dp),
        ) {
            //icono de búsqueda
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Buscar",
                tint = Color.Gray,
                modifier = Modifier.padding(start = 15.dp, top = 5.dp),
            )
            // Campo de texto de búsqueda
            Text(
                text = "Buscar",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 45.dp, top = 5.dp),
                color = Color.Gray
            )
        }

        // Título "Chats de las Peligrosas"
        Row(modifier = Modifier.padding(start = 19.dp, top = 10.dp)) {
            Icon(
                modifier = Modifier
                    .padding(top = 5.dp),
                imageVector = Icons.Rounded.Lock,
                contentDescription = "Chats Restringuidos",
                tint = Color.White
            )
            Text(
                text = "Chats de las Peligrosas",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                color = Color.White
            )
        }

        // Fila de botones --> Todos, No leídos, Favoritos
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Añade espacio entre botones
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { Log.i("Botón", "Todos seleccionados") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF113529),
                    contentColor = Color.White
                ),
            ) {
                Text(text = "Todos")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { Log.i("Botón", "No leídos seleccionados") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF113529),
                    contentColor = Color.White
                ),
            ) {
                Text(text = "No leídos")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { Log.i("Botón", "Favoritos seleccionados") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF113529),
                    contentColor = Color.White
                ),
            ) {
                Text(text = "Favoritos")
            }
        }

        // Lista de mensajes

        /*
         Las lazy columnas son una forma de mostrar una lista de elementos de manera eficiente.
            En lugar de cargar todos los elementos a la vez, solo carga los elementos que son visibles en la pantalla.
            Esto es útil cuando se trabaja con listas largas.

         */
        LazyColumn(
            modifier = modifier
                .height(500.dp)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(messages) { messageRes ->
                MessageRow(messageRes = messageRes, navController = navController)
            }
        }


        // Box con iconos inferiores --> Novedades, Llamadas, Chats, Ajustes, Más..
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF222222))
                .height(80.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Novedades
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xFF222222), CircleShape)
                        .size(60.dp),
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Novedades",
                    tint = Color.White
                )
                // Llamadas
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xFF222222), CircleShape)
                        .size(60.dp),
                    imageVector = Icons.Rounded.Call,
                    contentDescription = "Llamadas",
                    tint = Color.White
                )
                // Chats
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xFF222222), CircleShape)
                        .size(60.dp),
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Chats",
                    tint = Color.White
                )
                // Ajustes
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xFF222222), CircleShape)
                        .size(60.dp),
                    imageVector = Icons.Rounded.Settings,
                    contentDescription = "Ajustes",
                    tint = Color.White
                )
                // Más
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color(0xFF222222), CircleShape)
                        .size(60.dp),
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "Más",
                    tint = Color.White
                )
            }
        }
    }
}

/*
Esta funcion recibe un recurso de tipo Int y lo convierte a un texto
  para mostrarlo en la pantalla.
  Se encarga de mostrar la foto de perfil y el mensaje.
  , fuinciona de la siguiente manera ,  es una fila que contiene una imagen y un texto.
 */
@Composable
fun MessageRow(messageRes: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

        //todo prueba
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(65.dp)
                .padding(end = 16.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = messageRes), // Convertir el recurso a texto
            modifier = Modifier.clickable {
                navController.navigate(AppScreen.ChatWhatsApp.route)

            },
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppEjercicio_1Theme {
        FinalWhatsApp(navController = rememberNavController())
    }
}