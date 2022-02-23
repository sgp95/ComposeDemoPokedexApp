package com.santiago.guillen.composedemopokedexapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.santiago.guillen.composedemopokedexapp.R
import com.santiago.guillen.composedemopokedexapp.ui.theme.ComposeDemoPokedexAppTheme
import java.util.*
import kotlin.concurrent.schedule

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    ComposeDemoPokedexAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            Timer().schedule(3000) {
                onFinish()
            }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.splash),
                    contentDescription = "splash_icon"
                )
            }
        }
    }

}