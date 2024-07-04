package com.example.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.example.to_docompose.ui.screens.splash_screen.SplashScreen
import com.example.to_docompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                animationSpec = tween(
                    durationMillis = 1000
                ),
                targetOffsetY = { fullHeight -> -fullHeight }
            )
        }
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}