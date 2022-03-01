package com.santiago.guillen.composedemopokedexapp.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.santiago.guillen.composedemopokedexapp.ui.theme.ComposeDemoPokedexAppTheme
import com.santiago.guillen.composedemopokedexapp.ui.theme.colorByType
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class DetailActivity: ComponentActivity() {
    private val viewModel: DetailViewModel by viewModels()

    companion object {
        const val EXTRA_POKEMON_ID = "pokemonId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.pokemon.observe(this) {
            setContent {
                ComposeDemoPokedexAppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = colorByType(it.types.first().name?: "")
                    ) {
                        PokemonDetailLayout(it)
                    }
                }
            }
        }
        val pokemonId = intent.getIntExtra(EXTRA_POKEMON_ID, 0)
        viewModel.getPokemon(pokemonId)
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

        }
    }
}