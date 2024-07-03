package com.example.to_docompose.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Icon
import com.example.to_docompose.components.DisplayAlertDialog
import com.example.to_docompose.components.DisplayAlertDialogPreview
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.theme.ToDoComposeTheme
import com.example.to_docompose.util.Action

@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(text = "Add task")
        },
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onBackClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Icon back",
            tint = Color.White
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = {
        onAddClicked(Action.ADD)
    }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Icon add",
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            ExistingTaskAppBarActions(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    )
}

@Composable
fun ExistingTaskAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    var openDialog by remember {
        mutableStateOf(false)
    }

    DisplayAlertDialog(
        title = "Delete '${selectedTask.title}'?",
        message = "Are you sure you want to delete '${selectedTask.title}'?",
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { navigateToListScreen(Action.DELETE) }
    )

    DeleteAction(onDeleteClicked = {
        openDialog = true
    })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onCloseClicked(Action.NO_ACTION)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Icon Close",
            tint = Color.White
        )
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: () -> Unit
) {
    IconButton(
        onClick = {
            onDeleteClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Icon delete",
            tint = Color.White
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(
        onClick = {
            onUpdateClicked(Action.UPDATE)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Icon back",
            tint = Color.White
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NewTaskAppBarPreviewLight() {
    ToDoComposeTheme(darkTheme = false) {
        NewTaskAppBar(navigateToListScreen = {})
    }
}

@Composable
@Preview(showBackground = true)
fun NewTaskAppBarPreviewDark() {
    ToDoComposeTheme(darkTheme = true) {
        NewTaskAppBar(navigateToListScreen = {})
    }
}

@Composable
@Preview(showBackground = true)
fun ExistingTaskAppBarPreviewLight() {
    ToDoComposeTheme(darkTheme = false) {
        ExistingTaskAppBar(
            selectedTask = ToDoTask(0, "title", "some random text", Priority.LOW),
            navigateToListScreen = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ExistingTaskAppBarPreviewDark() {
    ToDoComposeTheme(darkTheme = true) {
        ExistingTaskAppBar(
            selectedTask = ToDoTask(0, "title", "some random text", Priority.LOW),
            navigateToListScreen = {}
        )
    }
}