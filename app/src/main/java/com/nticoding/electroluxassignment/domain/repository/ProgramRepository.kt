package com.nticoding.electroluxassignment.domain.repository

import com.nticoding.electroluxassignment.data.entity.Program
import kotlinx.coroutines.flow.Flow

interface ProgramRepository {

    suspend fun getAllPrograms(): Flow<List<Program>>
}