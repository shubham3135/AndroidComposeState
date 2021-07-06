package com.shubhamkumarwinner.composestate.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.shubhamkumarwinner.composestate.ui.theme.ComposeStateTheme

class TodoActivity : AppCompatActivity() {
    val todoViewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateTheme {
                Surface {
                    TodoActivityScreen(todoViewModel = todoViewModel)
                }
            }
        }
    }
}

@Composable
fun TodoActivityScreen(todoViewModel: TodoViewModel){
    val items: List<TodoItem> by todoViewModel.todoItems.observeAsState(listOf())

    TodoScreen(items = items, onAddItem = { todoViewModel.addItem(it) }, onRemoveItem = {todoViewModel.removeItem(it)})
}
