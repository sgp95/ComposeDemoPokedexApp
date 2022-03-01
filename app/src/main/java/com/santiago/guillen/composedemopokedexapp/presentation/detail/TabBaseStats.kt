package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.domain.model.Type
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
        repeat(pokemon.stats.size) {
            val color = if (it%2 == 0) { Color(0xFFFB6C6C) } else { Color(0xFF4BC07A) }
            val stat = pokemon.stats[it]
            val baseValue = (stat.baseValue?: 0).toFloat()
            val percent: Float = baseValue/100f
            RowBaseStats(stat.name?: "", stat.baseValue.toString(), min(1f, percent), color)
        }
        SubtitleMediumDark("Type Defenses", Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp))
        TextSmallLigthGray(
            "The effectiveness of each type on ${pokemon.name}",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 4.dp)
        )
        ChipGroup(pokemon.types)
    }
}

@Composable
fun ChipGroup(types: List<Type>) {
    Column (Modifier.padding(start = 12.dp, bottom = 24.dp, top = 12.dp)) {
        LazyRow {
            items(types) { type ->
                ChipOutlined(
                    name = type.name?: "",
                    color = colorByType(type.name?: "")
                )
            }
        }
    }
}

@Composable
fun RowBaseStats(title: String, statValue: String, statNumber: Float, progressColor: Color = Color(0xFFFB6C6C)) {
    Row (Modifier.padding(start = 24.dp, end = 24.dp)) {
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
                modifier = Modifier
                    .weight(6f)
                    .align(Alignment.CenterVertically),
                color = progressColor
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}