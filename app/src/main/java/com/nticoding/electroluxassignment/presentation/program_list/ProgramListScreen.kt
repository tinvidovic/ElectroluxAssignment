package com.nticoding.electroluxassignment.presentation.program_list

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.presentation.components.SelectableItemList

/**
 * Composable defining the program list screen
 * @param viewModel The [view model] [ProgramListViewModel]
 */
@Composable
fun ProgramListScreen(
    viewModel: ProgramListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    // The screen consumes VM state in order to render the UI
    val state = viewModel.state

    // The remembered scroll state, surviving config changes
    val scrollState = rememberScrollState()

    SelectableItemList(
        selectableOptions = state.selectableOptions,
        onSelectableClicked = { selectableOption ->
            // The screen passes events to the VM for handling
            viewModel.onEvent(
                ProgramListEvent.OnProgramSelected(selectableOption)
            )
        },
        modifier = Modifier
            .padding(
                top = 58.dp, // Top rectangle + top padding
                start = 16.dp,
                end = 16.dp
            )
            // Enable vertical scrolling for smaller display real-estates
            .verticalScroll(
                state = scrollState
            )
    )
}