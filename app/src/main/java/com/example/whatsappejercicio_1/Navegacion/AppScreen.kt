package com.example.whatsappejercicio_1.Navegacion


import android.media.MediaRouter

sealed class AppScreen(val route: String) {

    // me da error con el object  simplemente por eso pongo data object
    object MainActivity : AppScreen("MainActivity")
    object ChatWhatsApp : AppScreen("ChatWhatsApp")


}


/*
La clase `AppScreen` en el archivo `AppScreen.kt` define las rutas de navegación para la aplicación.
Utiliza una clase sellada (`sealed class`) para representar las diferentes pantallas de la aplicación, cada una con una ruta específica. Esto permite una navegación tipada
y segura en tiempo de compilación entre las diferentes pantallas de la aplicación.

Aquí está el propósito de cada parte de la clase:

- La clase `AppScreen` es una clase sellada que toma un parámetro `route` de tipo `String`.
- Los objetos `MainActivity` y `ChatWhatsApp` son subclases de `AppScreen` y representan las rutas para las pantallas principales de la aplicación.

Esto se utiliza en la función `AppNavigation` para definir las rutas de navegación en la aplicación.


sealed class AppScreen(val route: String) {
    object MainActivity : AppScreen("MainActivity")
    object ChatWhatsApp : AppScreen("ChatWhatsApp")
}

 */