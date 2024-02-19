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
import androidx.compose.runtime.currentCompositionLocalContext
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

@Composable
fun SelectableItem(
    selectableOption: SelectableOption,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = ElectroluxAssignmentTheme.shapes.small,
    color: Color = ElectroluxAssignmentTheme.colorScheme.container
) {
    Surface(
        onClick = { onSelected() },
        shape = shape,
        color = color,
        modifier = modifier,
    ) {

        val context = LocalContext.current

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
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
                Text(
                    text = selectableOption.title.asString(context),
                    style = ElectroluxAssignmentTheme.typography.title1,
                    textAlign = TextAlign.Start,
                    color = ElectroluxAssignmentTheme.colorScheme.contentPrimary
                )

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