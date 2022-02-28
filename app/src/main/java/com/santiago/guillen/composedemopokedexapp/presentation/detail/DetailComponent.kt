package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.ui.theme.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    ComposeDemoPokedexAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFB6C6C)
        ) {
            PokemonDetailLayout()
        }
    }
}
@ExperimentalPagerApi
@Composable
fun PokemonDetailLayout() {
    val pagerState = rememberPagerState(pageCount = 4)
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(start = 12.dp, top = 12.dp)
        ) {
            TitleH2Ligth("Charizard")
        }
        Row(
            Modifier
                .align(Alignment.End)
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Min)
                .padding(end = 12.dp)
        ) {
            SubtitleSmallLigth("#004")
        }
        Row(
            Modifier
                .width(IntrinsicSize.Max)
                .padding(start = 6.dp)
        ) {
            ChipOutlined("Flying")
            ChipOutlined("Fire")

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(12.dp))
        PokemonImage()
        TabsLayout(pagerState= pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun TabsLayout(pagerState: PagerState){
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
fun TabsContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        when (page){
            0 -> TabAboutLayout() // TabAboutLayout()
            1 -> TabBaseStatsLayout()
            2 -> TabEvolutionLayout()
            3 -> TabMovesLayout()
        }
    }
}
@Composable
fun PokemonImage() {
    Box {
        Spacer(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.White)
                .fillMaxWidth()
                .height(48.dp)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)) {
            Box(Modifier.align(alignment = Alignment.BottomEnd)) {
                Image(
                    painter = painterResource(R.drawable.pokeball),"",
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier.alpha(0.5f)
                )
            }
            Box(Modifier.align(alignment = Alignment.BottomCenter)) {
                Image(
                    painter = painterResource(R.drawable.ic_pk_charizard),"",
                    modifier = Modifier.padding(top = 24.dp),
                )
            }
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




