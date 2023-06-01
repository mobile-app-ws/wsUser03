package com.example.worldskills_app.navigation

import androidx.annotation.DrawableRes
import com.example.worldskills_app.R

enum class Navigation(
    val route: String
) {
    MAIN("MAIN"),
    SPLASH("SPLASH"),
    ONBOARD("ONBOARD"),
    AUTH("AUTH"),
    REQUAIDSMS("REQUAIDSMS"),
    ANALYZES("ANALYZES"),
    USER("USER"),
    RESULT("RESULT"),
    SUPPORT("SUPPORT");

    companion object {
        val screensWithBottomBar = listOf(
            MAIN.route, ANALYZES.route, USER.route, RESULT.route, SUPPORT.route
        )
    }
}

sealed class BottomBar(
    val route: String,
    @DrawableRes val resourceId: Int,
    val name: String
) {
    object ANALYZES : BottomBar(
        route = Navigation.ANALYZES.name,
        resourceId = R.drawable.ic_analyzes,
        name = "Анализы"
    )

    object USER : BottomBar(
        route = Navigation.USER.name,
        resourceId = R.drawable.ic_user,
        name = "Результаты"
    )

    object RESULT : BottomBar(
        route = Navigation.RESULT.name,
        resourceId = R.drawable.ic_result,
        name = "Поддержка"
    )

    object SUPPORT : BottomBar(
        route = Navigation.SUPPORT.name,
        resourceId = R.drawable.ic_support,
        name = "Профиль"
    )

    companion object {
        val listBottomBarElements = listOf(
            ANALYZES, USER, RESULT, SUPPORT
        )
    }
}