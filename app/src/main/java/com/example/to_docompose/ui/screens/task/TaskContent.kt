package com.example.to_docompose.ui.screens.task

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.components.PriorityDropDown
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.MEDIUM_PADDING
import com.example.to_docompose.ui.theme.ToDoComposeTheme

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = LARGE_PADDING)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = "Title") },
            textStyle = MaterialTheme.typography.bodyLarge,
            singleLine = true
        )

        Spacer(modifier = Modifier.height(MEDIUM_PADDING))
        
        PriorityDropDown(priority = priority, onPrioritySelected = onPrioritySelected)

        OutlinedTextField(
            modifier = Modifier
                .fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = "Description") },
            textStyle = MaterialTheme.typography.bodyLarge
        )

    }
}

@Composable
@Preview(showBackground = true)
fun TaskContentPreviewLight() {
    ToDoComposeTheme(
        darkTheme = false
    ) {
        TaskContent(
            title = "",
            onTitleChange = {},
            description = "",
            onDescriptionChange = {},
            priority = Priority.LOW,
            onPrioritySelected = {},
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskContentPreviewDark() {
    ToDoComposeTheme(
        darkTheme = true
    ) {
        TaskContent(
            title = "",
            onTitleChange = {},
            description = "",
            onDescriptionChange = {},
            priority = Priority.LOW,
            onPrioritySelected = {},
        )
    }
}