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
import com.santiago.guillen.composedemopokedexapp.ui.theme.SubtitleMediumDark
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallDarkGray
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallLigthGray

@Composable
fun TabBaseStatsLayout(pokemon: Pokemon) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        repeat(pokemon.stats.size) {
            val color = if (it%2 == 0) { Color(0xFFFB6C6C) } else { Color(0xFF4BC07A) }
            val stat = pokemon.stats[it]
            val baseValue = (stat.baseValue?: 0).toFloat()
            val percent: Float = baseValue/100f
            RowBaseStats(stat.name?: "", stat.baseValue.toString(), percent, color)
        }
        SubtitleMediumDark("Type Defenses", Modifier.padding(top = 24.dp))
        TextSmallLigthGray(
            "The effectiveness of each type on ${pokemon.name}",
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
    Spacer(Modifier.height(8.dp))
}