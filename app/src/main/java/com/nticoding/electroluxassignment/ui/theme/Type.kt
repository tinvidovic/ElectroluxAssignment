package com.nticoding.electroluxassignment.ui.theme

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nticoding.electroluxassignment.R
import com.nticoding.electroluxassignment.ui.theme.TypographyValues.body1TextStyle
import com.nticoding.electroluxassignment.ui.theme.TypographyValues.title1TextStyle


/**
 * Typography values, including Font families, typefaces, wrights and individual text styles
 * @see <a href="https://www.figma.com/file/xpyJ1NUYy69WxW7hKp4zNt/UI-Technical-Exercise?type=design
 * &node-id=0-1&mode=design&t=zPcRm1fWJujMIhj7-0">Figma design</a>
 */
object TypographyValues {
    private const val sfProRegularWeight = 400
    private const val sfProMediumWeight = 510

    private val sfProFontFamily = FontFamily(
        Font(
            resId = R.font.sf_pro_regular,
            weight = FontWeight(sfProRegularWeight)
        ),
        Font(
            resId = R.font.sf_pro_medium,
            weight = FontWeight(sfProMediumWeight)
        ),
    )

    val title1TextStyle = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight(sfProMediumWeight),
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

    val body1TextStyle = TextStyle(
        fontFamily = sfProFontFamily,
        fontWeight = FontWeight(sfProRegularWeight),
        fontSize = 14.sp,
        lineHeight = 21.sp,
    )
}


/**
 * The Typography scale includes all the necessary styles used in the application.
 * @property title1 Largest title text, reserved for component titles
 * @property body1 Largest body text, reserved for extended component descriptions
 */
@Immutable
data class Typography internal constructor(
    val title1: TextStyle = title1TextStyle,
    val body1: TextStyle = body1TextStyle,
)

/**
 * CompositionLocal used to specify the default typography
 */
internal val LocalTypography = staticCompositionLocalOf {
    // Static composition local (types are not expected to change)
    Typography()
}


@Preview
@Composable
fun Title1BasicText() {

    BasicText(
        text = "Hello World!",
        style = title1TextStyle
    )
}

@Preview
@Composable
fun Body1BasicText() {

    BasicText(
        text = "Hello World!",
        style = body1TextStyle
    )
}