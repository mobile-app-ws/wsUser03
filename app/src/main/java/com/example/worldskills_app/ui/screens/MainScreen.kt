package com.example.worldskills_app.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.worldskills_app.navigation.MyAppNavHost
import com.example.worldskills_app.navigation.Navigation
import com.example.worldskills_app.ui.screens.bottom_bar.WSBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val current by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            val nowOpen = Navigation.screensWithBottomBar.find {
                it == current?.destination?.route
            }

            if (nowOpen != null) {
                WSBottomBar(
                    navController = navController,
                    currentDestination = navController.currentDestination?.route ?: ""
                )
            }
        }
    ) { paddingValue ->
        MyAppNavHost(
            modifier = Modifier
                .padding(paddingValues = paddingValue),
            navController = navController
        )
    }
}