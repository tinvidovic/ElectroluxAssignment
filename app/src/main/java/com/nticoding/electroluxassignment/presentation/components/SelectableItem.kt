package com.nticoding.electroluxassignment.presentation.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.R
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.ui.theme.DisabledAlpha
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.util.UIText

/**
 *  A single selectable item containing an icon, title and optional description.
 * @param selectableOption The [SelectableOption] of the item
 * @param onSelected The callback function called when the item is clicked
 * @param modifier the [Modifier] to be applied to this selectable item.
 * @param shape shape of this selectable item.
 * @param color color of this selectable item.
 * @param enabled When disabled has 0.4f alpha and is not clickable
 */
@Composable
fun SelectableItem(
    selectableOption: SelectableOption,
    onSelected: (SelectableOption) -> Unit,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = ElectroluxAssignmentTheme.shapes.small,
    color: Color = ElectroluxAssignmentTheme.colorScheme.container,
    enabled: Boolean = true
) {

    val alphaModifier = modifier
        .alpha(if (enabled) 1f else DisabledAlpha)

    Surface(
        onClick = { if (enabled) onSelected(selectableOption) }, // Make the entire surface clickable
        shape = shape,
        color = color,
        modifier = alphaModifier
            .semantics(
                // Treat descendants as a single component
                mergeDescendants = true,
                properties = {
                    // Make talkback selection aware
                    this.selected = selectableOption.selected
                }
            )
    ) {

        val context = LocalContext.current

        Column {
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

                    Spacer(modifier = Modifier.height(4.dp))
                    // Description text (visible when selected)
                    // Simple visibility animation, to show/hide description if selected
                    AnimatedVisibility(visible = selectableOption.selected) {
                        Text(
                            text = selectableOption.description.asString(context),
                            style = ElectroluxAssignmentTheme.typography.body1,
                            textAlign = TextAlign.Start,
                            color = ElectroluxAssignmentTheme.colorScheme.contentSecondary,
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

            HorizontalDivider(
                thickness = 1.dp,
                color = ElectroluxAssignmentTheme.colorScheme.divider,
                modifier = Modifier.padding(
                    horizontal = 16.dp
                )
            )
        }

    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EnabledSelectableItemPreview() {

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

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DisabledSelectableItemPreview() {

    val selectableOption = SelectableOption(
        UIText.DynamicString("Cotton Eco"),
        UIText.DynamicString("Cupboard-dries cottons with maximum energy saving"),
        R.drawable.ic_faq
    )

    ElectroluxAssignmentTheme {
        SelectableItem(
            selectableOption = selectableOption,
            onSelected = { /*TODO*/ },
            enabled = false
        )
    }
}