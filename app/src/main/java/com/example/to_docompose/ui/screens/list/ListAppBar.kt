package com.example.to_docompose.ui.screens.list

//import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R
import com.example.to_docompose.components.PriorityItem
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.ToDoComposeTheme
import com.example.to_docompose.ui.theme.Typography

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks"
            )
        },
        actions = {
            ListAppBarActions(onSearchClicked, onSortClicked, onDeleteClicked)
        }
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked)
    SortAction(onSortClicked)
    DeleteAllAction(onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = { }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_tasks_description),
            tint = Color.White
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {

    var expended by remember {
        mutableStateOf(false)
    }

    val items = listOf(Priority.LOW, Priority.HIGH, Priority.NONE)

    IconButton(onClick = { expended = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_tasks_description),
            tint = Color.White
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { PriorityItem(priority = item) },
                    onClick = {
                        expended = false
                        onSortClicked(item)
                    }
                )
            }
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expended by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expended = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(R.string.delete_all),
            tint = Color.White
        )
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        modifier = Modifier.padding(start = LARGE_PADDING),
                        text = stringResource(R.string.delete_all),
                        style = Typography.titleSmall
                    )
                },
                onClick = {
                    expended = false
                    onDeleteClicked()
                }
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultListAppBarPreview() {
    ToDoComposeTheme(darkTheme = false) {
        DefaultListAppBar(
            onSearchClicked = {},
            onSortClicked = {},
            onDeleteClicked = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultListAppBarDarkPreview() {
    ToDoComposeTheme(darkTheme = true) {
        DefaultListAppBar(
            onSearchClicked = {},
            onSortClicked = {},
            onDeleteClicked = {}
        )
    }

}