package com.santiago.guillen.composedemopokedexapp.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class HomeActivity: ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(
                viewModel = viewModel,
                onPokemonClicked = {onPokemonClicked(it)}
            )
        }

//        viewModel.pokedexEntries.observe(this) {
//            setContent {
//                HomeScreen(
//                    entries = it,
//                    onLoadMore = { onLoadMore() },
//                    onPokemonClicked = {onPokemonClicked(it)}
//                )
//            }
//        }
//        viewModel.getEntries()
    }

    @ExperimentalPagerApi
    private fun onPokemonClicked(pokemon: Pokemon) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_POKEMON_ID, pokemon.id!!)
        })
    }

//    private fun onLoadMore() {
//        viewModel.getEntries()
//    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
}