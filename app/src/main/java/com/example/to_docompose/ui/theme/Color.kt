package com.example.to_docompose.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0XFFFF4646)
val NonePriorityColor = MediumGray//Color(0xFFFFFFFF)

private val ColorScheme.isLight: Boolean
    @Composable
    get() = MaterialTheme.colorScheme.background.luminance() > 0.5

val ColorScheme.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val ColorScheme.splashScreenBackground: Color
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val ColorScheme.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray