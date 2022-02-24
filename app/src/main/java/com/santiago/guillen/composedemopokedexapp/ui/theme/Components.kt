package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun Caption1Ligth(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = fontsPoppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color(android.graphics.Color.WHITE)
        ),
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
        modifier = Modifier.padding(start = 4.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp),
        border= BorderStroke(1.dp, Color.White),
        color = if (isSelected) Color.Black.copy(alpha = 0.4f) else Color.White.copy(alpha = 0f)
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
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

