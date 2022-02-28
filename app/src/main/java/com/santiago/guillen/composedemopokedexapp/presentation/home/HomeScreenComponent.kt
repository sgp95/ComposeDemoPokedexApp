package com.santiago.guillen.composedemopokedexapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.ui.theme.*
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(entries: List<Pokemon> = listOf(), onPokemonClicked: (pokemon: Pokemon) -> Unit) {
    ComposeDemoPokedexAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                TitleH2Dark("Pokedex", modifier = Modifier.padding(start = 10.dp, top = 4.dp))
                if(entries.isNullOrEmpty()) {
                    ProgressBar(true)
                } else {
                    GridList(entries, onPokemonClicked)
                }
            }
        }
    }
}

@Composable
fun PokedexEntryCard(pokemon: Pokemon, onPokemonClicked: (pokemon: Pokemon) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 5.dp, vertical = 10.dp)
        .clickable { onPokemonClicked(pokemon) },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        backgroundColor = colorByType(pokemon.types.first().name!!)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .align(Alignment.BottomEnd),
                painter = painterResource(id = R.drawable.pokeball),
                colorFilter = ColorFilter.tint(PokeballInCard),
                contentDescription = null
            )
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp, vertical = 10.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(start = 5.dp)) {
                SubtitleMediumLight(text = pokemon.name!!, modifier = Modifier.padding(bottom = 5.dp), color = TextOnPrimary)
                ChipOutlined(pokemon.types[0].name!!.capitalize(), fontSize = 10.sp)
                if(pokemon.types.size > 1) ChipOutlined(pokemon.types[1].name!!.capitalize(), fontSize = 10.sp)
            }
            Box(contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.weight(1f)) {
                Column {
                    GlideImage(imageModel = pokemon.imageUrl,
                        contentScale = ContentScale.FillWidth)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(pokemons: List<Pokemon>, onPokemonClicked: (pokemon: Pokemon) -> Unit) {
    val entries = remember { mutableStateListOf<Pokemon>() }
    entries.addAll(pokemons)
//    val list = (1..10).map { it.toString() }
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp, 4.dp),
        content = {
            items(entries.size) { index ->
                PokedexEntryCard(pokemon = entries[index], onPokemonClicked)
            }
        })
}