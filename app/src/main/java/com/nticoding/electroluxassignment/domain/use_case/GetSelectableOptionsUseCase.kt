package com.nticoding.electroluxassignment.domain.use_case

import com.nticoding.electroluxassignment.domain.mapper.toSelectableOption
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.domain.repository.ProgramRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest



class GetSelectableOptionsUseCase(
    private val programRepository: ProgramRepository
) {

    /**
     * Fetches the stored programs and maps the List<Program> flow to a List<SelectableOption> flow
     */
    suspend operator fun invoke(): Flow<List<SelectableOption>> = channelFlow {

        programRepository.getAllPrograms().collectLatest { programs ->

            val selectableOptions = programs.map {
                it.toSelectableOption()
            }

            send(selectableOptions)
        }
    }
}