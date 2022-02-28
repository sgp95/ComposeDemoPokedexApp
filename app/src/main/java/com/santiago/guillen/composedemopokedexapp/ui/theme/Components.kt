package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Texts

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
                    fontSize = 14.sp,
                    color = Color(android.graphics.Color.WHITE)
                ),
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 20.dp)
            )
        }
    }
}

