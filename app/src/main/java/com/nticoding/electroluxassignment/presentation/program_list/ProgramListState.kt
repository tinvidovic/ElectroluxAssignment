package com.nticoding.electroluxassignment.presentation.program_list

import android.os.Parcelable
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import kotlinx.parcelize.Parcelize
import java.io.Serializable

/**
 * Represents the state of the [ProgramListScreen].
 * @param selectableOptions The list of selectable options to display
 */
data class ProgramListState(
    val selectableOptions: List<SelectableOption> = emptyList(),
) : Serializable