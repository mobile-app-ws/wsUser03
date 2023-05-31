package com.example.worldskills_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.worldskills_app.ui.screens.auth.AuthScreen
import com.example.worldskills_app.ui.screens.onboard.OnBoardScreen
import com.example.worldskills_app.ui.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Navigation.SPLASH.name
    ) {
        composable(Navigation.SPLASH.name) {
            SplashScreen()
            LaunchedEffect(
                Unit
            ) {
                delay(3000)

                navController.navigate(Navigation.ONBOARD.name)
            }
        }
        composable(Navigation.ONBOARD.name){
            OnBoardScreen(
                onCancel = {
                    navController.navigate(Navigation.MAIN.name)
                }
            )
        }
        composable(Navigation.AUTH.name){
            AuthScreen()
        }
    }
}
