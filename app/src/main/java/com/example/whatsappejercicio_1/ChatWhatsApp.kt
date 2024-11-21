package com.example.whatsappejercicio_1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.whatsappejercicio_1.ui.theme.WhatsAppEjercicio_1Theme





/*
La función `ChatApp` es una función composable en Jetpack Compose que define la interfaz de usuario para una pantalla de chat. Aquí está el desglose de lo que hace:

1. Estado de los mensajes: Utiliza `remember` y `mutableStateOf` para mantener el estado de los mensajes en la conversación.
2. Estado del mensaje actual: Utiliza `remember` y `mutableStateOf` para mantener el estado del mensaje que el usuario está escribiendo.
3. Encabezado del chat: Muestra un encabezado con un ícono de retroceso y el título del chat.
4. Lista de mensajes: Muestra una lista de mensajes en una columna que se puede desplazar verticalmente.
5. Entrada de texto: Proporciona un campo de texto para que el usuario escriba nuevos mensajes y un botón para enviar el mensaje.

La función organiza estos elementos en una columna que ocupa toda la pantalla y tiene un fondo negro.
 */
@Composable
fun ChatApp(navController: NavController) {



    var messages by remember {
        mutableStateOf(
            listOf(
                Pair("¿Sabes qué es lo que más me gusta de ti?", false),
                Pair("¿Qué?", true),
                Pair("Tu sonrisa... y lo que me imagino que puedes hacer con esos labios...", false),
                Pair("Vas a hacerme ruborizar con esos halagos... 😏", true),
                Pair("Lo único que ruboriza es lo que tengo en mente para ti", false),
                Pair("¿Ah sí? Me muero por saber qué tienes en mente... 😏", true),
                Pair("Tal vez... una cita donde pueda demostrarte...", false),
                Pair("¿Qué tienes en mente para nuestra cita? Estoy curioso...", true),
                Pair("Solo tú y yo, en un lugar íntimo, sin interrupciones... 😉", false)

            )
        )
    }

    var currentMessage by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        // Encabezado del grupo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(36.dp)
        ) {

            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable { navController.popBackStack() } // Navega hacia atrás
            )

            Text(
                text = "Chat con Crush",
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Lista de mensajes
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(8.dp)
        ) {
            messages.forEach { (message, isSender) ->
                MessageBubble(message = message, isSender = isSender)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Entrada de texto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = currentMessage,
                onValueChange = { currentMessage = it },
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(12.dp),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier,
                onClick = {
                    if (currentMessage.text.isNotEmpty()) {
                        messages = messages + Pair(currentMessage.text, true)
                        currentMessage = TextFieldValue("") // Limpia el campo
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF113529),
                    contentColor = Color.White
                ),
            ) {
                Text("Enviar")
            }
        }
    }
}


/*
La función `MessageBubble` es una función composable en Jetpack Compose que muestra un mensaje en una burbuja de chat.
Toma dos parámetros: `message`, que es el texto del mensaje, e `isSender`, un booleano que indica si el mensaje fue enviado por el usuario.
 La burbuja se alinea a la derecha si el mensaje es enviado y a la izquierda si es recibido. La burbuja tiene un color de fondo verde claro para los mensajes enviados
 y gris oscuro para los recibidos, con texto negro y blanco respectivamente.
La burbuja también tiene bordes redondeados y un padding interno para el texto.
 */
@Composable
fun MessageBubble(message: String, isSender: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isSender) Color(0xFFDCF8C6) else Color(0xFF2A2A2A),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        ) {
            Text(
                text = message,
                color = if (isSender) Color.Black else Color.White,
                fontSize = 16.sp
            )
        }
    }
}






// Elevacion de nivel de abstraccion
/*
El código seleccionado define una función composable llamada `MainActivityComposable` que configura el tema de la aplicación
y utiliza un `Scaffold` para estructurar la interfaz de usuario principal.
Dentro del `Scaffold`, se llama a la función `FinalWhatsApp` con un `Modifier` y un `NavController` para manejar la navegación.


 */

@Composable
fun MainActivityComposable(navController: NavController) {
    WhatsAppEjercicio_1Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FinalWhatsApp(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}