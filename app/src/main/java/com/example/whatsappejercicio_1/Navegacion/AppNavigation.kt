package com.example.whatsappejercicio_1.Navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.whatsappejercicio_1.MainActivityComposable
import com.example.whatsappejercicio_1.ChatApp


//  Esta función es la encargada de la navegación entre pantallas de la aplicación.
//  Se encarga de definir las rutas y las pantallas a las que se navegará.
//  Se encarga de definir la pantalla de inicio de la aplicación.

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.MainActivity.route) {
        composable(AppScreen.MainActivity.route) {
            MainActivityComposable(navController)
        }
        composable(AppScreen.ChatWhatsApp.route) {
            ChatApp(navController)
        }
    }
}
