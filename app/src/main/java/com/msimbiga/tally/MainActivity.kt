package com.msimbiga.tally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.msimbiga.tally.screen.daily.DailyScreen
import com.msimbiga.tally.screen.daily.DailyScreenDestination
import com.msimbiga.tally.screen.splash.SplashScreen
import com.msimbiga.tally.screen.splash.SplashScreenDestination
import com.msimbiga.tally.ui.theme.WeightTrackerTheme

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