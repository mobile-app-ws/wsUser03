package com.example.worldskills_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.worldskills_app.modules.clientModule
import com.example.worldskills_app.modules.dataStoreModule
import com.example.worldskills_app.modules.viewModelsModule
import com.example.worldskills_app.ui.screens.MainScreen
import com.example.worldskills_app.ui.theme.WorldskillsappTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(
                viewModelsModule,
                clientModule,
                dataStoreModule
            )
        }
        setContent {
            WorldskillsappTheme {
                MainScreen()
            }
        }
    }
}