package com.nticoding.electroluxassignment

import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable1Description
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable1Title
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable2Description
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable2Title
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable3Description
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable3Title
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable4Description
import com.nticoding.electroluxassignment.SelectableItemTest.Constants.selectable4Title
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.presentation.components.SelectableItem
import com.nticoding.electroluxassignment.ui.theme.DisabledAlpha
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.ui.theme.darkColorScheme
import com.nticoding.electroluxassignment.ui.theme.lightColorScheme
import com.nticoding.electroluxassignment.util.UIText
import com.nticoding.electroluxassignment.util.assertBackgroundColor
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class SelectableItemTest {

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

                Column {

                    // Selectable 1, enabled, selected
                    SelectableItem(
                        selectableOption = SelectableOption(
                            UIText.DynamicString(selectable1Title),
                            UIText.DynamicString(selectable1Description),
                            R.drawable.ic_faq,
                            selected = true
                        ),
                        onSelected = {},
                        enabled = true
                    )

                    // Selectable 2, disabled, not selected
                    SelectableItem(
                        selectableOption = SelectableOption(
                            UIText.DynamicString(selectable2Title),
                            UIText.DynamicString(selectable2Description),
                            R.drawable.ic_faq,
                            selected = true
                        ),
                        onSelected = {},
                        enabled = false
                    )

                    // Selectable 3, enabled, selected
                    SelectableItem(
                        selectableOption = SelectableOption(
                            UIText.DynamicString(selectable3Title),
                            UIText.DynamicString(selectable3Description),
                            R.drawable.ic_faq,
                            selected = false
                        ),
                        onSelected = {},
                        enabled = true
                    )

                    // Selectable 4, disabled, not selected
                    SelectableItem(
                        selectableOption = SelectableOption(
                            UIText.DynamicString(selectable4Title),
                            UIText.DynamicString(selectable4Description),
                            R.drawable.ic_faq,
                            selected = false
                        ),
                        onSelected = {},
                        enabled = false
                    )
                }

            }
        }
    }

    @Test
    fun selectable1_enableAndSelectedPropertiesCorrect() {

        // Should exist
        composeRule
            .onNodeWithText(selectable1Title)
            .assertIsDisplayed()

        // Description should be visible
        composeRule
            .onNodeWithText(selectable1Description)
            .assertIsDisplayed()

        composeRule
            .onNodeWithText(selectable1Title)
            .assertBackgroundColor(if (isInDarkMode) darkColorScheme().contentPrimary else lightColorScheme().contentPrimary)

    }

    @Test
    fun selectable2_enableAndSelectedPropertiesCorrect() {

        // Should exist
        composeRule
            .onNodeWithText(selectable2Title)
            .assertIsDisplayed()

        // Description should be visible
        composeRule
            .onNodeWithText(selectable2Description)
            .assertIsDisplayed()

        var contentColor =
            if (isInDarkMode) darkColorScheme().contentPrimary else lightColorScheme().contentPrimary
        contentColor = contentColor.copy(
            alpha = DisabledAlpha
        )

        composeRule
            .onNodeWithText(selectable2Title)
            .assertBackgroundColor(contentColor)
    }

    @Test
    fun selectable3_enableAndSelectedPropertiesCorrect() {

        // Should exist
        composeRule
            .onNodeWithText(selectable3Title)
            .assertIsDisplayed()

        // Description should not be visible
        composeRule
            .onNodeWithText(selectable3Description)
            .assertDoesNotExist()

        composeRule
            .onNodeWithText(selectable3Title)
            .assertBackgroundColor(if (isInDarkMode) darkColorScheme().contentPrimary else lightColorScheme().contentPrimary)
    }

    @Test
    fun selectable4_enableAndSelectedPropertiesCorrect() {

        // Should exist
        composeRule
            .onNodeWithText(selectable4Title)
            .assertIsDisplayed()

        // Description should be visible
        composeRule
            .onNodeWithText(selectable4Description)
            .assertDoesNotExist()

        var contentColor =
            if (isInDarkMode) darkColorScheme().contentPrimary else lightColorScheme().contentPrimary
        contentColor = contentColor.copy(
            alpha = DisabledAlpha
        )

        composeRule
            .onNodeWithText(selectable4Title)
            .assertBackgroundColor(contentColor)
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

