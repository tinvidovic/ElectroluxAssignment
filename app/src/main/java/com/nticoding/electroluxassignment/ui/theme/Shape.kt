package com.nticoding.electroluxassignment.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp


private val radiusSmall = 8.dp

/**
 * Shapes define the style of container corners. Containers provide a shape parameter that allows
 * for custom shapes. The shape can be changed either by a per component basis or for all components
 * by overriding the shape parameter of the [ElectroluxAssignmentTheme].
 * @property small Shape style with 4 same-sized and using [RoundedCornerShape] by default. Used by
 * the following containers: [/TODO: list components]
 */
// Mark with Immutable annotation to help composition optimization as the parameters of created
// instances will not change
@Immutable
data class Shapes(
    val small: CornerBasedShape = RoundedCornerShape(radiusSmall)
)

/**
 * CompositionLocal used to specify the default shapes for the surfaces
 */
internal val LocalShapes = staticCompositionLocalOf {
    // Static composition local (shapes are not expected to change)
    Shapes()
}