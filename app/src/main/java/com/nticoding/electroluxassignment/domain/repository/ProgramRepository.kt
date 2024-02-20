package com.nticoding.electroluxassignment.domain.repository

import com.nticoding.electroluxassignment.data.entity.Program
import kotlinx.coroutines.flow.Flow

interface ProgramRepository {

    /**
     * Fetches and returns a flow of [Program]s from a data source
     */
    suspend fun getAllPrograms(): Flow<List<Program>>
}