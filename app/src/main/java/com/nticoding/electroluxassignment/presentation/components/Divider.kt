package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme

/**
 *  A divider is a thin line that groups content in lists and layouts.
 * @param modifier the [Modifier] to be applied to this divider line.
 * @param thickness thickness of this divider line.
 * @param color color of this divider line.
 */
@Composable
fun HorizontalDivider(
    thickness: Dp,
    modifier: Modifier = Modifier,
    color: Color = HorizontalDividerDefaults.color,
) {

    // A divider is a simple [Box] with the specified height and background color
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .background(
                color = color
            )
    )

}

/** Default values for [HorizontalDivider]s */
object HorizontalDividerDefaults {
    /** Default color of a horizontal divider. */
    val color: Color @Composable get() = ElectroluxAssignmentTheme.colorScheme.divider
}