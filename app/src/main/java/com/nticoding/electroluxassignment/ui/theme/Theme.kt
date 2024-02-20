package com.nticoding.electroluxassignment.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

/**
 * All values may be set by providing this component with the [colorScheme][ColorScheme],
 * [shapes][Shapes] and [typography][Typography] attributes. Use this to configure the overall
 * theme of elements within this ElectroluxAssignmentTheme.
 *
 *  Any values that are not set will inherit the current value from the theme, falling back to the
 *  defaults.
 *
 * @param colorScheme The [color scheme][ColorScheme] to be used for this hierarchy
 * @param typography The [color typography][Typography] to be used for this hierarchy
 * @param shapes The [shapes][Shapes] to be used for this hierarchy
 *
 */
@Composable
fun ElectroluxAssignmentTheme(
    colorScheme: ColorScheme = ElectroluxAssignmentTheme.colorScheme,
    typography: Typography = ElectroluxAssignmentTheme.typography,
    shapes: Shapes = ElectroluxAssignmentTheme.shapes,
    content: @Composable () -> Unit
) {

    val isDarkTheme = isSystemInDarkTheme()

    val rememberedColorScheme = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colorScheme]
        // provided, and overwrite the values set in it.
        if (isDarkTheme) darkColorScheme() else lightColorScheme()
    }

    CompositionLocalProvider(
        LocalColorScheme provides rememberedColorScheme,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {

        content()
    }
}

/**
 * Contains functions to access the current theme values provided at the call site's position in
 * the hierarchy.
 */
object ElectroluxAssignmentTheme {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}