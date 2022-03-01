package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.ui.theme.SubtitleMediumDark
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallDarkGray
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallLigthGray

@Composable
fun TabAboutLayout(pokemon: Pokemon) {
    BoxWithConstraints {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 12.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Row(Modifier.fillMaxWidth()) {
                TextSmallDarkGray(
                    (pokemon.description ?: "").replace("\n", " "),
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(Modifier.height(12.dp))
            BoxHeightWeightAbilities(pokemon)
            Spacer(Modifier.height(8.dp))
            SubtitleMediumDark("Breeding", Modifier.padding(top = 12.dp))
            Spacer(Modifier.height(8.dp))
            GenderRow()
            Spacer(Modifier.height(8.dp))
            RowAboutInformation("Egg Groups", pokemon.getEggGroup())
        }
    }
}

@Composable
private fun BoxHeightWeightAbilities(pokemon: Pokemon) {
    val heightMetersValue = pokemon.height?.div(10f)
    val heightFeetValue = (heightMetersValue)?.times(3.281f)
    val heightMeters = String.format("%.2f m", heightMetersValue)
    val heightFeet = String.format("(%.2fft)", heightFeetValue)

    val weightKgValue = pokemon.weight?.div(10f)
    val weightFeetValue = (weightKgValue)?.times(2.205f)
    val weightKg = String.format("%.2f kg", heightMetersValue)
    val weightLbs = String.format("(%.2f lbs)", weightFeetValue)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            TextSmallLigthGray("Abilities")
            TextSmallDarkGray(pokemon.getAbilities())
            Spacer(Modifier.height(8.dp))
            RowHeightAndWeight(heightMeters, heightFeet, weightKg, weightLbs)
        }
    }
}

@Composable
private fun RowHeightAndWeight(
    heightMeters: String,
    heightFeet: String,
    weightKg: String,
    weightLbs: String
) = Box {
    Row(
        modifier = Modifier
            .align(alignment = Alignment.Center),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            TextSmallLigthGray("Height")
            TextSmallDarkGray(
                "$heightMeters $heightFeet",
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            TextSmallLigthGray("Weight")
            TextSmallDarkGray("$weightKg $weightLbs")
        }

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