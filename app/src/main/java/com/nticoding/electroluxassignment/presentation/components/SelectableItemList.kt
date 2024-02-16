package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.nticoding.electroluxassignment.R
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme

@Composable
fun SelectableItemList(
    selectableOptions: List<SelectableOption>,
    onSelectableClicked: (SelectableOption) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ElectroluxAssignmentTheme.shapes.small,
) {

    Surface(
        onClick = {},
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
            "Cotton",
            "Cotton description",
            R.drawable.ic_cotton
        ),
        SelectableOption(
            "Cotton Eco",
            "Cotton Eco description",
            R.drawable.ic_cotton,
            true
        ),
        SelectableOption(
            "Synthetics",
            "Synthetics description",
            R.drawable.ic_synthetics
        ),
        SelectableOption(
            "Sports",
            "Sports description",
            R.drawable.ic_cotton
        ),
    )
    SelectableItemList(
        selectableOptions = selectableOptions,
        onSelectableClicked = {}
    )
}