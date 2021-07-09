package com.shubhamkumarwinner.composestate.todo

import com.google.common.truth.Truth.assertThat
import com.shubhamkumarwinner.composestate.util.generateRandomTodoItem
import org.junit.Test

class TodoViewModelTest{
    @Test
    fun whenRemovingItem_updatesList() {
        // before
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        // during
        viewModel.removeItem(item1)

        // after
        assertThat(viewModel.todoItems).isEqualTo(listOf(item2))
    }

    @Test
    fun whenAddItem_updatesList() {
        // before
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        viewModel.addItem(item1)
        assertThat(viewModel.todoItems).isEqualTo(listOf(item1))

        val item2 = generateRandomTodoItem()
        viewModel.addItem(item2)
        assertThat(viewModel.todoItems).isEqualTo(listOf(item1, item2))

    }

    @Test
    fun whenNotEditing_currentEditItemIsNull() {
        val subject = TodoViewModel()
        val item = generateRandomTodoItem()
        subject.addItem(item)
        assertThat(subject.currentEditItem).isNull()
    }
}