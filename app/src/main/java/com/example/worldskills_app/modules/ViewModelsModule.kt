package com.example.worldskills_app.modules

import com.example.worldskills_app.ui.screens.auth.AuthViewModel
import com.example.worldskills_app.ui.screens.onboard.OnBoardViewModel
import com.example.worldskills_app.ui.screens.requaidsms.RequiredSmsViewModel
import com.example.worldskills_app.ui.screens.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::OnBoardViewModel)
    viewModelOf(::AuthViewModel)
    viewModelOf(::RequiredSmsViewModel)
}