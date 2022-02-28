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
import com.santiago.guillen.composedemopokedexapp.ui.theme.SubtitleMediumDark
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallDarkGray
import com.santiago.guillen.composedemopokedexapp.ui.theme.TextSmallLigthGray


@Composable
fun TabAboutLayout() {
    val verticalSpace = 8.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Row {
            TextSmallLigthGray(
                "Species",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "Seed",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
        Spacer(Modifier.height(verticalSpace))
        Row {
            TextSmallLigthGray(
                "Height",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "2'3.6'' (0.70 cm)",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
        Spacer(Modifier.height(verticalSpace))
        Row {
            TextSmallLigthGray(
                "Weight",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "15.2 lbs (6.9 kg)",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
        Spacer(Modifier.height(verticalSpace))
        Row {
            TextSmallLigthGray(
                "Abilities",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "Overgrow, Chiorophyl",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
        SubtitleMediumDark("Breeding", Modifier.padding(top = 12.dp))
        Spacer(Modifier.height(verticalSpace))
        GenderRow()
        Spacer(Modifier.height(verticalSpace))
        Row {
            TextSmallLigthGray(
                "Egg Groups",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "Monster",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
        Spacer(Modifier.height(verticalSpace))
        Row {
            TextSmallLigthGray(
                "Egg Cycle",
                Modifier.weight(1f),
                TextAlign.Justify
            )
            TextSmallDarkGray(
                "Grass",
                Modifier.weight(2f),
                TextAlign.Justify
            )
        }
    }
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