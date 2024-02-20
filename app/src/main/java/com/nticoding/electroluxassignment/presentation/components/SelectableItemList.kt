package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.nticoding.electroluxassignment.R
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.util.UIText

/**
 * A list of [selectable items] [SelectableItem].
 * @param selectableOptions The [SelectableOption]s to list
 * @param onSelectableClicked The callback function called when an item is clicked
 * @param modifier the [Modifier] to be applied to this selectable item.
 * @param shape shape of this selectable item.
 */
@Composable
fun SelectableItemList(
    selectableOptions: List<SelectableOption>,
    onSelectableClicked: (SelectableOption) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ElectroluxAssignmentTheme.shapes.small,
) {

    Surface(
        onClick = null,
        shape = shape,
        color = ElectroluxAssignmentTheme.colorScheme.container,
        modifier = modifier
    ) {

        Column {

            for (selectableOption in selectableOptions) {

                SelectableItem(
                    selectableOption = selectableOption,
                    onSelected = { onSelectableClicked(selectableOption) }
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectableItemListPreview() {

    val selectableOptions = listOf<SelectableOption>(
        SelectableOption(
            UIText.DynamicString("Cotton"),
            UIText.DynamicString("Cotton description"),
            R.drawable.ic_cotton
        ),
        SelectableOption(
            UIText.DynamicString("Cotton Eco"),
            UIText.DynamicString("Cotton Eco description"),
            R.drawable.ic_cotton,
            true
        ),
        SelectableOption(
            UIText.DynamicString("Synthetics"),
            UIText.DynamicString("Synthetics description"),
            R.drawable.ic_synthetics
        ),
        SelectableOption(
            UIText.DynamicString("Sports"),
            UIText.DynamicString("Sports description"),
            R.drawable.ic_cotton
        ),
    )
    SelectableItemList(
        selectableOptions = selectableOptions,
        onSelectableClicked = {}
    )
}