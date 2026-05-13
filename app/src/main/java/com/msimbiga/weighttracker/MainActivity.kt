package com.msimbiga.weighttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msimbiga.weighttracker.screen.daily.DailyScreen
import com.msimbiga.weighttracker.screen.daily.DailyScreenDestination
import com.msimbiga.weighttracker.screen.splash.SplashScreen
import com.msimbiga.weighttracker.screen.splash.SplashScreenDestination
import com.msimbiga.weighttracker.ui.theme.WeightTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeightTrackerTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = SplashScreenDestination) {
                    composable<SplashScreenDestination> {
                        SplashScreen(onLoadingFinish = { navController.navigate(
                            DailyScreenDestination) })
                    }
                    composable<DailyScreenDestination> { DailyScreen() }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WeightTrackerTheme {
//        Greeting("Android")
//    }
//}