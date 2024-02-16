package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme

@Composable
fun Surface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = ElectroluxAssignmentTheme.colorScheme.background,
    content: @Composable () -> Unit,
) {

    Box(
        modifier = modifier
            .background(
                shape = shape,
                color = color
            )
            .clip(shape)
            .clickable(
                role = Role.Button,
                enabled = enabled,
                onClick = onClick
            )
    ) {
        content()
    }
}