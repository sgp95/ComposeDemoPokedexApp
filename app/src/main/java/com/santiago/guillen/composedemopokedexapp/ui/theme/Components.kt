package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * This file will contain all the components/widgets shared between the screens.
 */

/**
 * Text Components
 */
@Composable
fun TitleH2Ligth(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsLato,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 42.sp,
            color = Color(android.graphics.Color.WHITE)
        ),
    )
}

@Composable
fun TitleH2Dark(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsLato,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 42.sp,
            color = Color.Black
        ),
    )
}

@Composable
fun SubtitleSmallLigth(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.White
        ),
    )
}

@Composable
fun SubtitleMediumDark(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.DarkGray
        ),
    )
}

@Composable
fun SubtitleMediumLight(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = color
        ),
    )
}

@Composable
fun TextSmallLigthGray(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.LightGray
        ),
        textAlign = textAlign
    )
}

@Composable
fun TextSmallDarkGray(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = Color.DarkGray
        ),
        textAlign = textAlign
    )
}

@Composable
fun CaptionDark(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        color = Color.DarkGray,
        fontSize = 12.sp,
        modifier = modifier
    )
}

// Buttons

@Composable
fun ChipOutlined(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
    fontSize: TextUnit = 14.sp,
) {
    Surface(
        modifier = Modifier.padding(start = 6.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp),
        border= BorderStroke(1.dp, Color.White),
        color = if (isSelected) Color.Black.copy(alpha = 0.4f) else Color.White.copy(alpha = 0.15f)
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontFamily = fontsLato,
                    fontWeight = FontWeight.Bold,
                    fontSize = fontSize,
                    color = Color(android.graphics.Color.WHITE)
                ),
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp)
            )
        }
    }
}

/**
 * Loader
 */
@Composable
fun ProgressBar(isLoading: Boolean = false) {
    ComposeDemoPokedexAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val show = remember { mutableStateOf(false) }
            show.value = isLoading
            if(show.value)
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.height(80.dp).width(80.dp)
                    )
                }
            else
                Unit
        }
    }
}
