package com.santiago.guillen.composedemopokedexapp.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.domain.model.Type
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getEntries()
        setContent {
            HomeScreen() { onPokemonClicked(it) }
        }

        viewModel.pokedexEntries.observe(this) {
            setContent {
                HomeScreen(it) { onPokemonClicked(it) }
            }
        }

        viewModel.pokemon.observe(this) {
        }
    }

    private fun onPokemonClicked(pokemon: Pokemon) {
        viewModel.getPokemon(pokemon.id!!)
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
}