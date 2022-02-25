package com.santiago.guillen.composedemopokedexapp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.ui.theme.*

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
@Composable
fun PokemonDetailLayout() {
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
        TabsLayout()
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
        Box(Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
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
fun TabsLayout(){
    val tabsNames = listOf(
        "Stats",
        "Base Stats",
        "Evolution",
        "Moves"
    )

    val tabIndex = 0

    // TAB
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier
            .background(color = Color.White)
    ) {
        tabsNames.forEachIndexed { index, text ->
            TabLight(tabIndex, index, text) {

            }
        }
    }

}

@Composable
private fun TabLight(tabIndex: Int, index: Int, text: String, onClick: () -> Unit) {
    Tab(
        selected = tabIndex == index,
        modifier = Modifier
            .background(Color.White),
        onClick = onClick,
        text = {
            CaptionDark(
                modifier = Modifier
                    .background(Color.White),
                text = text
            )
        })
}



