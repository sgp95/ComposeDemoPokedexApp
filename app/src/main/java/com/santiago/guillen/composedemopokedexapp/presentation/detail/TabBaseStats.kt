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
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.domain.model.Stat
import com.santiago.guillen.composedemopokedexapp.ui.theme.*
import kotlin.math.min

@Composable
fun TabBaseStatsLayout(pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        repeat(pokemon.stats.size) { rowNumber ->
            RowBaseStats(pokemon.stats[rowNumber], rowNumber)
        }
        SubtitleMediumDark(
            text = "Type Defenses",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp)
        )
        TextSmallLigthGray(
            text = "The effectiveness of each type on ${pokemon.name}",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 4.dp)
        )
        ChipVerticalGrid(
            spacing = 2.dp,
            modifier = Modifier
                .padding(7.dp)
        ) {
            pokemon.types.forEach { word ->
                ChipOutlined(
                    name = word.name?: "",
                    color = colorByType(word.name?: "").copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
fun RowBaseStats(stat: Stat, rowNumber: Int) {
    val progressColor = if (rowNumber % 2 == 0) {
        Color(0xFFFB6C6C)
    } else {
        Color(0xFF4BC07A)
    }
    val baseValue = (stat.baseValue?: 0).toFloat()
    val percent: Float = baseValue/100f

    Row (Modifier.padding(start = 24.dp, end = 24.dp)) {
        TextSmallLigthGray(
            text = stat.name?: "",
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Justify
        )
        Row(Modifier.weight(11f)) {
            TextSmallDarkGray(
                stat.baseValue.toString(),
                textAlign = TextAlign.Justify,
                modifier = Modifier.weight(1f)
            )
            LinearProgressIndicator(
                progress = min(1f, percent),
                modifier = Modifier
                    .weight(6f)
                    .align(Alignment.CenterVertically),
                color = progressColor
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}