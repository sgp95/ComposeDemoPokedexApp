package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.ui.theme.Caption1Ligth
import com.santiago.guillen.composedemopokedexapp.ui.theme.ChipOutlined
import com.santiago.guillen.composedemopokedexapp.ui.theme.ComposeDemoPokedexAppTheme
import com.santiago.guillen.composedemopokedexapp.ui.theme.TitleH2Ligth

@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    ComposeDemoPokedexAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFB6C6C)
        ) {
            HeaderPage()
        }
    }
}

@Composable
fun HeaderPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(start = 12.dp, top = 12.dp)
        ) {
            TitleH2Ligth("Charmander")
        }
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Min)
                .align(Alignment.End)
                .padding(end = 12.dp)
        ) {
            Caption1Ligth("#004")
        }
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(start = 8.dp)
        ) {
            ChipOutlined("Posion")
        }
    }
}


