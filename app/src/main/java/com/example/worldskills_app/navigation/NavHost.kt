package com.example.worldskills_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.worldskills_app.data.DataStore
import com.example.worldskills_app.ui.screens.analyzes.AnalyzesScreen
import com.example.worldskills_app.ui.screens.auth.AuthScreen
import com.example.worldskills_app.ui.screens.onboard.OnBoardScreen
import com.example.worldskills_app.ui.screens.requaidsms.RequiredSmsScreen
import com.example.worldskills_app.ui.screens.result.ResultScreen
import com.example.worldskills_app.ui.screens.splash.SplashScreen
import com.example.worldskills_app.ui.screens.support.SupportScreen
import com.example.worldskills_app.ui.screens.user.UserScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.get

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val dataStore = get<DataStore>()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Navigation.SPLASH.name
    ) {
        composable(Navigation.MAIN.name) {

        }
        composable(Navigation.ANALYZES.name) {
            AnalyzesScreen()
        }
        composable(Navigation.USER.name) {
            UserScreen()
        }
        composable(Navigation.SUPPORT.name) {
            SupportScreen()
        }
        composable(Navigation.RESULT.name) {
            ResultScreen()
        }
        composable(Navigation.SPLASH.name) {
            SplashScreen()
            LaunchedEffect(
                Unit
            ) {
                delay(3000)
                dataStore.isShowOnBoardFlow.collectLatest {
                    if (it) {
                        navController.navigate(Navigation.ONBOARD.name)
                    } else {
                        navController.navigate(Navigation.AUTH.name)
                    }
                }
            }
        }
        composable(Navigation.ONBOARD.name) {
            OnBoardScreen(
                onCancel = {
                    navController.navigate(Navigation.AUTH.name)
                },
                onSwipe = {
                    navController.navigate(Navigation.AUTH.name)
                }
            )
        }
        composable(Navigation.AUTH.name) {
            AuthScreen(
                onGoNext = {
                    navController.navigate(Navigation.REQUAIDSMS.name)
                },
                onGoToMain = {
                    navController.navigate(Navigation.ANALYZES.name)
                }
            )
        }
        composable(Navigation.REQUAIDSMS.name) {
            RequiredSmsScreen(

            )
        }
    }
}
