package com.msimbiga.tally.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

@Serializable
object SplashScreenDestination

@Composable
fun SplashScreen(
    onLoadingFinish: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(2000)
        onLoadingFinish()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(

        )
    }
}