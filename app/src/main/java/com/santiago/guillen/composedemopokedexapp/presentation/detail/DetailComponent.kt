package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.domain.model.Pokemon
import com.santiago.guillen.composedemopokedexapp.ui.theme.*
import kotlinx.coroutines.launch
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    ComposeDemoPokedexAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFB6C6C)
        ) {

        }
    }
}
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun PokemonDetailLayout(pokemon: Pokemon) {
    val pagerState = rememberPagerState(pageCount = 4)
    /*
    val pagerState = rememberPagerState(pageCount = 4)
    Column {
        PokemonImage(pokemon.imageUrl)
        TabsButtons(pagerState= pagerState)
        TabsLayout(pagerState = pagerState, pokemon)
    }
    * */
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
    ) {
        stickyHeader { HeaderDetail(pokemon) }
        item { PokemonImage(pokemon.imageUrl) }
        item { TabsButtons(pagerState= pagerState) }
        item { TabsLayout(pagerState = pagerState, pokemon) }
    }

}
@Composable
fun HeaderDetail(pokemon: Pokemon) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(start = 12.dp, top = 12.dp)
        ) {
            TitleH2Ligth(pokemon.name?: "")
        }
        Box(
            Modifier
                .align(Alignment.End)
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Min)
                .padding(end = 12.dp)
        ) {
            val number = "#${pokemon.pokedexNumber?: ""}"
            SubtitleSmallLigth(number, modifier = Modifier.align(Alignment.CenterEnd))
        }
        LazyRow(modifier = Modifier.padding(start = 6.dp)) {
            items(pokemon.types) { pokemon ->
                ChipOutlined(pokemon.name?: "")
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsButtons(pagerState: PagerState){
    val scope = rememberCoroutineScope()
    val tabsNames = listOf(
        "About",
        "Base Stats",
        "Evolution",
        "Moves"
    )
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        divider = {
            TabRowDefaults.Divider(
                thickness = 3.dp,
                color = Color.White
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color(0xFF6C79DB)
            )

        },
        modifier = Modifier.background(color = Color.White)
    ) {
        tabsNames.forEachIndexed { index, text ->
            Tab(
                modifier = Modifier.background(Color.White),
                selected = pagerState.currentPage == index ,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    CaptionDark(
                        modifier = Modifier.background(Color.White),
                        text = text
                    )
                })
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsLayout(pagerState: PagerState, pokemon: Pokemon) {
    HorizontalPager(state = pagerState, Modifier.background(Color.White)) { page ->
        when (page){
            0 -> TabAboutLayout(pokemon) // TabAboutLayout()
            1 -> TabBaseStatsLayout(pokemon)
            2 -> TabEvolutionLayout()
            3 -> TabMovesLayout()
        }
    }
}
@Composable
fun PokemonImage(imageUrl: String?) {
    Box(Modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .clip(shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(Color.White)
                .fillMaxWidth()
                .height(32.dp)
        )
        Box(Modifier.align(alignment = Alignment.BottomEnd)) {
            Image(
                painter = painterResource(R.drawable.pokeball),"",
                colorFilter = ColorFilter.tint(color = Color.White),
                modifier = Modifier.alpha(0.5f)
            )
        }
        Box(Modifier.align(alignment = Alignment.BottomCenter)) {
            GlideImage(imageModel = imageUrl, contentScale = ContentScale.Fit)
        }
    }
}

@Composable
fun TabEvolutionLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }
}

@Composable
fun TabMovesLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }
}




