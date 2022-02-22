package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryDark,
    secondary = SecondaryDark,
    background = SecondaryLight,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnSecondary
)

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = PrimaryLight,
    secondary = Secondary,
    background = SecondaryLight,
    onPrimary = TextOnPrimary,
    onSecondary = TextOnSecondary

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeDemoPokedexAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}