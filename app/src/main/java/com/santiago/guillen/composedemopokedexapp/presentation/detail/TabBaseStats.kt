package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.ui.theme.SubtitleMediumDark
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallDarkGray
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallLigthGray

@Composable
fun TabBaseStatsLayout() {
    val verticalSpace = 8.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        RowBaseStats("HP", "46", 0.46f)
        Spacer(Modifier.height(verticalSpace))
        RowBaseStats("Attack", "60", 0.8f, Color(0xFF4BC07A))
        Spacer(Modifier.height(verticalSpace))
        RowBaseStats("Defense", "48", 0.36f)
        Spacer(Modifier.height(verticalSpace))
        RowBaseStats("5p. Atk", "65", 0.71f, Color(0xFF4BC07A))
        Spacer(Modifier.height(verticalSpace))
        RowBaseStats("Speed", "65", 0.25f)
        Spacer(Modifier.height(verticalSpace))
        RowBaseStats("Total", "317", 0.85f, Color(0xFF4BC07A))
        Spacer(Modifier.height(verticalSpace))
        SubtitleMediumDark("Type Defenses", Modifier.padding(top = 24.dp))
        TextSmallLigthGray(
            "The effectiveness of each type on Charizard",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun RowBaseStats(title: String, statValue: String, statNumber: Float, progressColor: Color = Color(0xFFFB6C6C)) {
    Row {
        TextSmallLigthGray(
            title,
            Modifier.weight(3f),
            TextAlign.Justify
        )
        Row(Modifier.weight(11f)) {
            TextSmallDarkGray(
                statValue,
                textAlign = TextAlign.Justify,
                modifier = Modifier.weight(1f)
            )
            LinearProgressIndicator(
                progress = statNumber,
                modifier = Modifier.weight(6f).align(Alignment.CenterVertically),
                color = progressColor
            )
        }
    }
}