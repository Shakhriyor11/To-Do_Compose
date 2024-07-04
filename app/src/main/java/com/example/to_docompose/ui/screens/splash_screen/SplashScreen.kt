package com.example.to_docompose.ui.screens.splash_screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import com.example.to_docompose.ui.theme.ToDoComposeTheme
import com.example.to_docompose.ui.theme.splashScreenBackground

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.splashScreenBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = getLogo()),
            contentDescription = ""
        )
    }
}

@Composable
fun getLogo() : Int {
    return if (isSystemInDarkTheme()) {
        R.drawable.logo_dark
    } else {
        R.drawable.logo_light
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreviewLight() {
    ToDoComposeTheme(
        darkTheme = false
    ) {
        SplashScreen()
    }
}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreviewDark() {
    ToDoComposeTheme(
        darkTheme = true
    ) {
        SplashScreen()
    }
}