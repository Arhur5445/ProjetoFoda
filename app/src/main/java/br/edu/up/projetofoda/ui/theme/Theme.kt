package br.edu.up.projetofoda.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Definição das cores para o tema escuro
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Definição das cores para o tema claro
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE), // Cor de fundo padrão
    surface = Color(0xFFFFFBFE), // Cor de superfície padrão
    onPrimary = Color.White, // Cor do texto sobre o primário
    onSecondary = Color.White, // Cor do texto sobre o secundário
    onTertiary = Color.White, // Cor do texto sobre o terciário
    onBackground = Color(0xFF1C1B1F), // Cor do texto sobre o fundo
    onSurface = Color(0xFF1C1B1F) // Cor do texto sobre a superfície
)

@Composable
fun ProjetoFodaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Certifique-se de definir Typography em outro lugar
        content = content
    )
}
