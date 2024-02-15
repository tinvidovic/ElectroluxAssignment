package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import com.nticoding.electroluxassignment.ui.theme.chaosBlack

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    style: TextStyle = TextDefaults.textStyle,
    textAlign: TextAlign = TextDefaults.textAlign
) {

    // The text color is taken in order of: provided argument -> provided style -> default (chaosBlack)
    val textColor = color.takeOrElse {
        style.color.takeOrElse {
            chaosBlack
        }
    }

    val mergedStyle = style.copy(
        color = textColor,
        textAlign = textAlign
    )

    BasicText(
        text = text,
        modifier = modifier,
        style = mergedStyle
    )
}

/** Default values for [Text]s */
object TextDefaults {
    /** Default color of a [Text]. */
    val textStyle: TextStyle @Composable get() = ElectroluxAssignmentTheme.typography.title1

    /** Default text alignment of a [Text]. */
    val textAlign: TextAlign = TextAlign.Center
}

@Preview
@Composable
fun DefaultTextPreview() {
    Text(text = "Hello World!")
}

@Preview
@Composable
fun BodyTextPreview() {
    Text(
        text = "Hello World!",
        style = ElectroluxAssignmentTheme.typography.body1
    )
}

@Preview
@Composable
fun CustomTextPreview() {
    Text(
        text = "Hello World!",
        style = ElectroluxAssignmentTheme.typography.body1,
        color = Color(0xFFFF5671),
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
    )
}