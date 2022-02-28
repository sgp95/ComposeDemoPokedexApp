package com.santiago.guillen.composedemopokedexapp.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.santiago.guillen.composedemopokedexapp.ui.theme.ComposeDemoPokedexAppTheme

@ExperimentalPagerApi
class DetailActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoPokedexAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFB6C6C)
                ) {
                    PokemonDetailLayout()
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeDemoPokedexAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFB6C6C)
        ) {
            PokemonDetailLayout()
        }
    }
}