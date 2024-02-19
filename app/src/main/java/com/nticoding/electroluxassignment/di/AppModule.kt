package com.nticoding.electroluxassignment.di

import com.nticoding.electroluxassignment.data.ProgramDataStore
import com.nticoding.electroluxassignment.data.repository.ProgramRepository
import com.nticoding.electroluxassignment.domain.use_case.GetSelectableOptionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt Application level module. Provides necessary dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProgramRepository(): com.nticoding.electroluxassignment.domain.repository.ProgramRepository {

        return ProgramRepository(
            programDataStore = ProgramDataStore()
        )
    }

    @Provides
    @Singleton
    fun provideGetSelectableOptionsUseCase(
        programRepository: com.nticoding.electroluxassignment.domain.repository.ProgramRepository
    ): GetSelectableOptionsUseCase {

        return GetSelectableOptionsUseCase(
            programRepository = programRepository
        )
    }
}