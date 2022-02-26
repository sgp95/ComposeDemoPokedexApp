package com.santiago.guillen.composedemopokedexapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * This file will contain all the components/widgets shared between the screens.
 */
@Composable
fun ProgressBar(isLoading: Boolean = false) {
    ComposeDemoPokedexAppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val show = remember { mutableStateOf(false) }
            show.value = isLoading
            if(show.value)
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.height(80.dp).width(80.dp)
                    )
                }
            else
                Unit
        }
    }
}