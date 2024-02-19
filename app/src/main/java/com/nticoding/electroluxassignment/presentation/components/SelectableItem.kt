package com.nticoding.electroluxassignment.presentation.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.R
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.util.UIText

/**
 *  A single selectable item containing an icon, title and optional description.
 * @param selectableOption The [SelectableOption] of the item
 * @param onSelected The callback function called when the item is clicked
 * @param modifier the [Modifier] to be applied to this selectable item.
 * @param shape shape of this selectable item.
 * @param color color of this selectable item.
 */
@Composable
fun SelectableItem(
    selectableOption: SelectableOption,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = ElectroluxAssignmentTheme.shapes.small,
    color: Color = ElectroluxAssignmentTheme.colorScheme.container
) {
    Surface(
        onClick = { onSelected() }, // Make the entire surface clickable
        shape = shape,
        color = color,
        modifier = modifier,
    ) {

        val context = LocalContext.current

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            // Leading Icon
            Icon(
                painter = painterResource(id = selectableOption.iconResId),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 16.dp
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        vertical = 16.dp
                    )
            ) {
                // Title text
                Text(
                    text = selectableOption.title.asString(context),
                    style = ElectroluxAssignmentTheme.typography.title1,
                    textAlign = TextAlign.Start,
                    color = ElectroluxAssignmentTheme.colorScheme.contentPrimary
                )

                // Description text (visible when selected)
                // Simple visibility animation, to show/hide description if selected
                AnimatedVisibility(visible = selectableOption.selected) {
                    Text(
                        text = selectableOption.description.asString(context),
                        style = ElectroluxAssignmentTheme.typography.body1,
                        textAlign = TextAlign.Start,
                        color = ElectroluxAssignmentTheme.colorScheme.contentSecondary
                    )
                }
            }

            // Display checked icon if selected
            if (selectableOption.selected) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 16.dp
                        )
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SelectableItemPreview() {

    val selectableOption = SelectableOption(
        UIText.DynamicString("Cotton Eco"),
        UIText.DynamicString("Cupboard-dries cottons with maximum energy saving"),
        R.drawable.ic_faq
    )

    ElectroluxAssignmentTheme {
        SelectableItem(
            selectableOption = selectableOption,
            onSelected = { /*TODO*/ },
        )
    }
}