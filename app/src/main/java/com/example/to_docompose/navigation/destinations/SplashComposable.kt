package com.example.to_docompose.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.to_docompose.ui.screens.splash_screen.SplashScreen
import com.example.to_docompose.util.Constants.SPLASH_SCREEN

//@Composable
//fun SplashComposable() {}

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}