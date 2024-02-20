package com.nticoding.electroluxassignment

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import com.nticoding.electroluxassignment.data.ProgramDataStore
import com.nticoding.electroluxassignment.data.entity.Program
import com.nticoding.electroluxassignment.domain.repository.ProgramRepository
import com.nticoding.electroluxassignment.domain.use_case.GetSelectableOptionsUseCase
import com.nticoding.electroluxassignment.presentation.components.Surface
import com.nticoding.electroluxassignment.presentation.program_list.ProgramListScreen
import com.nticoding.electroluxassignment.presentation.program_list.ProgramListViewModel
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ProgramListScreenTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var programDataStore: ProgramDataStore
    private lateinit var programRepository: ProgramRepository
    private lateinit var getSelectableOptionsUseCase: GetSelectableOptionsUseCase
    private lateinit var programListViewModel: ProgramListViewModel

    private lateinit var testContext: Context

    @Before
    fun setUp() {

        // Initialize dependencies


        // It is fine to use actual implementation as it is already a mock in itself and will not
        // cause flakiness
        programDataStore = ProgramDataStore()

        programRepository = object : ProgramRepository {
            override suspend fun getAllPrograms(): Flow<List<Program>> = flow {
                emit(programDataStore.getAllPrograms())
            }
        }

        getSelectableOptionsUseCase = GetSelectableOptionsUseCase(
            programRepository = programRepository
        )

        programListViewModel = ProgramListViewModel(
            savedStateHandle = SavedStateHandle(),
            getSelectableOptionsUseCase = getSelectableOptionsUseCase
        )


        composeRule.activity.setContent {
            ElectroluxAssignmentTheme {

                testContext = LocalContext.current

                Surface(
                    onClick = null,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ProgramListScreen(
                        viewModel = programListViewModel
                    )
                }

            }
        }
    }

    @Test
    fun selectItem_exactlyOneSelected() {

        for (i in 0..20) {
            // Select random item
            val randomSelectableOption = programListViewModel.state.selectableOptions.random()

            // Click it
            composeRule
                .onNodeWithText(randomSelectableOption.title.asString(composeRule.activity.applicationContext))
                .performClick()

            // Assert that it is expanded
            composeRule
                .onNodeWithText(randomSelectableOption.description.asString(composeRule.activity.applicationContext))
                .assertExists()

            val expectedNumberOfSelectedItems = 1

            val actualNumberOfSelectedItems = programListViewModel.state.selectableOptions.count {
                it.selected
            }

            // Exactly 1 item is expected to be selected
            assertThat(actualNumberOfSelectedItems).isEqualTo(expectedNumberOfSelectedItems)
        }
    }

}