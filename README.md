# WhatsAppEjercicio_1

Este proyecto es una aplicación de mensajería similar a WhatsApp, desarrollada en Kotlin utilizando Jetpack Compose para la interfaz de usuario y Jetpack Navigation para la navegación entre pantallas.
## Características

- Pantalla Principal: Muestra una lista de contactos con los que puedes chatear.
- Pantalla de Chat: Permite enviar y recibir mensajes en un chat.
## Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- Android Studio
- Gradle

## Comenzando

### Requisitos Previos

- Android Studio
- Dispositivo Android o emulador


### Dependencias


- Jetpack Compose
- Jetpack Navigation
- Material3

### Gradle Configuration
```python

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.navigation:navigation-compose:2.7.3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

```




## Estructura del Proyecto

- `src/main/java/com/example/whatsappejercicio_1/MainActivity.kt`: Actividad principal que contiene la lógica de la interfaz de usuario.
- `src/main/java/com/example/whatsappejercicio_1/Navegacion/AppNavigation.kt`: Gestiona la navegación entre la pantalla principal y la pantalla de chat.
- `src/main/java/com/example/whatsappejercicio_1/Navegacion/AppScreen.kt`: Define las rutas de navegación.
- `src/main/java/com/example/whatsappejercicio_1/ChatWhatsApp.kt`: Implementa la pantalla de chat.
- `src/main/java/com/example/whatsappejercicio_1/MainActivityComposable.kt`: Implementa la pantalla principal con la lista de contactos.
- `src/main/res/values/strings.xml`: Recursos de cadena para la aplicación.
- `src/main/res/drawable/ic_profile.xml`: Marcador de posición para la foto de perfil.

