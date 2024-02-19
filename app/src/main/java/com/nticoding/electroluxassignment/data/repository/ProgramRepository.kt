package com.nticoding.electroluxassignment.data.repository

import com.nticoding.electroluxassignment.data.ProgramDataStore
import com.nticoding.electroluxassignment.data.repository.ProgramRepository.Constants.SIMULATED_DELAY_MS
import com.nticoding.electroluxassignment.data.entity.Program
import com.nticoding.electroluxassignment.domain.repository.ProgramRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProgramRepository(
    private val programDataStore: ProgramDataStore
): ProgramRepository {
    override suspend fun getAllPrograms(): Flow<List<Program>> = flow {

        // First emit an empty list to simulate loading while fetching
        emptyList<Program>()

        // Simulate a delay
        delay(SIMULATED_DELAY_MS)

        // Returned the result (always successful for simplicity)
        programDataStore.getAllPrograms()
    }

    object Constants {

        const val SIMULATED_DELAY_MS = 2000L
    }
}