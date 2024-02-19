package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme

/**
 * A Surface is a convenience wrapper around the [Box] composable. It allows specifying the onClick
 * callback, color and shape of the underlying Box.
 * @param modifier Modifier to be applied to the layout corresponding to the surface
 * @param onClick The callback called when the surface is clicked
 * @param enabled Weather the surface should be enabled
 * @param shape Defines the surface's shape
 * @param color The background color. Use [Color.Transparent] to have no color.
 */
@Composable
fun Surface(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = ElectroluxAssignmentTheme.colorScheme.background,
    content: @Composable () -> Unit,
) {

    val boxModifier = if (onClick != null) {
        modifier
            .background(
                shape = shape,
                color = color
            )
            .clip(shape)
            // Make it clickable when a callback is provided only
            .clickable(
                enabled = enabled,
                indication = null, // We don't want a ripple effect ever
                role = Role.Button,
                interactionSource = remember { MutableInteractionSource() }) {
                // Perform the onClick
                onClick()
            }
    } else {
        // No callback provided, create an unclickable surface
        modifier
            .background(
                shape = shape,
                color = color
            )
            .clip(shape)
    }
    Box(
        modifier = boxModifier
    ) {
        content()
    }
}