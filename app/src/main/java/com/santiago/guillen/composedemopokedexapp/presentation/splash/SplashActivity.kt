package com.santiago.guillen.composedemopokedexapp.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.santiago.guillen.composedemopokedexapp.presentation.home.HomeActivity


@ExperimentalFoundationApi
@ExperimentalPagerApi
class SplashActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SplashScreen {
        Log.d("rastroSplashActivity", "splashDone")
    }
}