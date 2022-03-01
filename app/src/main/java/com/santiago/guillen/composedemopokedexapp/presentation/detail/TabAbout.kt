package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.ui.theme.SubtitleMediumDark
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallDarkGray
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallLigthGray

@Composable
fun TabAboutLayout(pokemon: Pokemon) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        RowAboutInformation("Species", "Seed")
        RowAboutInformation("Height", pokemon.height.toString())
        RowAboutInformation("Weight",  pokemon.weight.toString())
        RowAboutInformation("Abilities", pokemon.getAbilities())
        SubtitleMediumDark("Breeding", Modifier.padding(top = 12.dp))
        Spacer(Modifier.height(8.dp))
        GenderRow()
        Spacer(Modifier.height(8.dp))
        RowAboutInformation("Egg Groups", pokemon.getEggGroup())
        RowAboutInformation("Egg Cycle", "Grass")
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun RowAboutInformation(title: String, description: String) {
    val verticalSpace = 8.dp
    Row {
        TextSmallLigthGray(
            title,
            Modifier.weight(1f),
            TextAlign.Justify
        )
        TextSmallDarkGray(
            description,
            Modifier.weight(2f),
            TextAlign.Justify
        )
    }
    Spacer(Modifier.height(verticalSpace))
}

@Composable
fun GenderRow() {
    Row {
        TextSmallLigthGray(
            "Gender",
            Modifier.weight(1f),
            TextAlign.Justify
        )
        Row(modifier = Modifier.weight(2f)) {
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_male),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    tint = Color(0XFFA7AFE9),
                    contentDescription = null
                )
                TextSmallDarkGray("87.5%", Modifier.padding(start = 4.dp))
            }
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_female),
                    modifier = Modifier.align(Alignment.CenterVertically),
                    tint = Color(0XFFF5A1C0),
                    contentDescription = null
                )
                TextSmallDarkGray("12.5%", Modifier.padding(start = 4.dp))
            }

        }
    }
}