package com.nticoding.electroluxassignment

import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable1Description
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable1Title
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable2Description
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable2Title
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable3Description
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable3Title
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable4Description
import com.nticoding.electroluxassignment.SelectableListTest.Constants.selectable4Title
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.presentation.components.SelectableItemList
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.util.UIText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class SelectableListTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    private var isInDarkMode: Boolean = false

    @Before
    fun setUp() {

        composeRule.activity.setContent {

            ElectroluxAssignmentTheme {

                isInDarkMode = isSystemInDarkTheme()

                val selectableOptions = remember {
                    mutableStateOf(
                        listOf(
                            SelectableOption(
                                UIText.DynamicString(selectable1Title),
                                UIText.DynamicString(selectable1Description),
                                R.drawable.ic_faq,
                                selected = false
                            ),
                            SelectableOption(
                                UIText.DynamicString(selectable2Title),
                                UIText.DynamicString(selectable2Description),
                                R.drawable.ic_faq,
                                selected = true
                            ),
                            SelectableOption(
                                UIText.DynamicString(selectable3Title),
                                UIText.DynamicString(selectable3Description),
                                R.drawable.ic_faq,
                                selected = false
                            ),
                            SelectableOption(
                                UIText.DynamicString(selectable4Title),
                                UIText.DynamicString(selectable4Description),
                                R.drawable.ic_faq,
                                selected = false
                            ),
                        )
                    )
                }
                SelectableItemList(
                    selectableOptions = selectableOptions.value,
                    onSelectableClicked = {selectedOption ->
                        selectableOptions.value = selectableOptions.value.map {
                            if (it.title == selectedOption.title) {
                                it.copy(
                                    selected = selectedOption.selected.not()
                                )
                            } else {
                                it
                            }
                        }
                    }
                )

            }
        }
    }

    @Test
    fun selectableItemList_selectionToggledOnClick() {

        // Should not exist at first
        composeRule
            .onNodeWithText(selectable1Description)
            .assertDoesNotExist()

        // Click on it to select it
        composeRule
            .onNodeWithText(selectable1Title)
            .performClick()

        // Should now exist
        composeRule
            .onNodeWithText(selectable1Description)
            .assertExists()

        // Should exist at first
        composeRule
            .onNodeWithText(selectable2Description)
            .assertExists()

        // Click on it to unselect it
        composeRule
            .onNodeWithText(selectable2Title)
            .performClick()

        // Should no longer exist
        composeRule
            .onNodeWithText(selectable2Description)
            .assertDoesNotExist()
    }
    
    object Constants {

        const val selectable1Title = "Test Selectable 1"
        const val selectable1Description = "Test Selectable 1 Description"

        const val selectable2Title = "Test Selectable 2"
        const val selectable2Description = "Test Selectable 2 Description"

        const val selectable3Title = "Test Selectable 3"
        const val selectable3Description = "Test Selectable 3 Description"

        const val selectable4Title = "Test Selectable 4"
        const val selectable4Description = "Test Selectable 4 Description"
    }
}