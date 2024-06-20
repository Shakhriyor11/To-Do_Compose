package com.example.to_docompose.ui.screens.list

//import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.ui.theme.DarkGray
import com.example.to_docompose.ui.theme.ToDoComposeTheme

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Tasks"
            )
        },
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DefaultListAppBarPreview() {
    ToDoComposeTheme(darkTheme = false) {
        DefaultListAppBar()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DefaultListAppBarDarkPreview() {
    ToDoComposeTheme(darkTheme = true) {
        DefaultListAppBar()
    }

}