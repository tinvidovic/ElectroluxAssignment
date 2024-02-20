package com.nticoding.electroluxassignment.presentation.program_list

import com.nticoding.electroluxassignment.domain.model.SelectableOption

/**
 * Sealed class, representing available user actions in the [ProgramListScreen]
 */
sealed class ProgramListEvent {

    data class OnProgramSelected(val selectableOption: SelectableOption) : ProgramListEvent()
}