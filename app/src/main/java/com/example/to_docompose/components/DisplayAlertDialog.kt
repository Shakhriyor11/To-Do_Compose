package com.example.to_docompose.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.to_docompose.ui.theme.ToDoComposeTheme
import com.example.to_docompose.ui.theme.taskItemTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            onDismissRequest = { closeDialog() },
            confirmButton = {
                Button(onClick = {
                    onYesClicked()
                    closeDialog()
                }) {
                    Text(
                        text = "Yes"
                    )
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {
                    closeDialog()
                }) {
                    Text(
                        text = "No"
                    )
                }
            },
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.taskItemTextColor
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Normal
                    )
            },
            containerColor = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DisplayAlertDialogPreview() {
    ToDoComposeTheme(
        darkTheme = false
    ) {
        DisplayAlertDialog(
            title = "Title",
            message = "Message",
            openDialog = true,
            closeDialog = {},
            onYesClicked = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DisplayAlertDialogDarkPreview() {
    ToDoComposeTheme(
        darkTheme = true
    ) {
        DisplayAlertDialog(
            title = "Title",
            message = "Message",
            openDialog = true,
            closeDialog = {},
            onYesClicked = {}
        )
    }
}