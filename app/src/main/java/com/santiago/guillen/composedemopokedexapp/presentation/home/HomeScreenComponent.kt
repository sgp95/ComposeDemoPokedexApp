package com.santiago.guillen.composedemopokedexapp.presentation.home

import android.util.Log
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
fun HomeScreen(entries: List<Pokemon> = listOf()) {
    ComposeDemoPokedexAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            GridList(entries)
        }
    }
}

@Composable
fun PokedexEntryCard(pokemon: Pokemon) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 5.dp, vertical = 10.dp)
        .clickable { Log.d("rastro", "Click card") },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        backgroundColor = colorByType(pokemon.types.first().name!!)) {
        Box(contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.height(30.dp).width(30.dp)) {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                colorFilter = ColorFilter.tint(PokeballInCard),
                contentDescription = "splash_icon"
            )
        }
        Row(modifier = Modifier.fillMaxSize()
            .padding(horizontal = 5.dp, vertical = 10.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = pokemon.name!!,
                    color = TextOnPrimary,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
                ShipText(value = pokemon.types[0].name!!)
                if(pokemon.types.size > 1) ShipText(value = pokemon.types[1].name!!)
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

@Composable
fun ShipText(value: String) {
    Box(contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(PokeballInCard)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(text = value,
            color = TextOnPrimary,
            fontSize = 10.sp
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(pokemons: List<Pokemon>) {
    val entries = remember { mutableStateListOf<Pokemon>() }
    entries.addAll(pokemons)
//    val list = (1..10).map { it.toString() }
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp, 4.dp),
        content = {
            items(entries.size) { index ->
                PokedexEntryCard(pokemon = entries[index])
            }
        })
}