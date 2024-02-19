package com.nticoding.electroluxassignment.presentation.program_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.nticoding.electroluxassignment.domain.mapper.toSelectableOption
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.domain.repository.ProgramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the [ProgramListScreen]. Utilises Dagger-Hilt to provide dependencies.
 * @param programRepository A concrete [ProgramRepository] implementation
 */
@HiltViewModel
class ProgramListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val programRepository: ProgramRepository
): ViewModel() {

    /**
     * The [screen] [ProgramListScreen] [state] [ProgramListState]
     */
    @OptIn(SavedStateHandleSaveableApi::class)
    var state: ProgramListState by savedStateHandle.saveable {
        mutableStateOf(ProgramListState())
    }

    init {

        // Load the programs when initializing
        if (state.selectableOptions.isEmpty()) {
            // Load only when empty, otherwise use the saved Bundle
            loadPrograms()
        }
    }

    /**
     * Receives [events][ProgramListEvent] corresponding to user actions from the [ProgramListScreen]
     * and handles them.
     */
    fun onEvent(event: ProgramListEvent) {

        when (event) {
            is ProgramListEvent.OnProgramSelected -> {
                // A program was selected, update the state
                state = state.copy(
                    selectableOptions = state.selectableOptions.map {
                        it.copy(
                            selected = it == event.selectableOption
                        )
                    }
                )
            }
        }
    }

    /**
     * Consumes the [ProgramRepository] program flow and populates the selectableOptions state
     * variable
     */
    private fun loadPrograms() {

        viewModelScope.launch {
            // For each emission update the state
            programRepository.getAllPrograms().collectLatest {programs ->

                state = state.copy(
                    selectableOptions = programs.map {
                        it.toSelectableOption()
                    }
                )
            }
        }
    }
}