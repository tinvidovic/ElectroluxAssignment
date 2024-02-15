package com.nticoding.electroluxassignment.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.R

/**
 * An icon component that draws [painter] using [tint], with a default value
 * of [Color.Unspecified] (no tint). If [painter] has no intrinsic size, this component will use the
 * recommended default size.
 *
 * @param painter [Painter] to draw inside this icon
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes, and
 * does not represent a meaningful action that a user can take. This text should be localized
 * @param modifier the [Modifier] to be applied to this icon
 * @param tint tint to be applied to [painter]. [Color.Unspecified] is provided by default, which
 * does not apply any tint.
 */
@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    val colorFilter = if (tint == Color.Unspecified) null else ColorFilter.tint(tint)

    // Semantics for accessibility with contentDescription and the Image role
    val semantics =
        if (contentDescription != null) {
            Modifier.semantics {
                this.contentDescription = contentDescription
                this.role = Role.Image
            }
        } else {
            Modifier
        }
    Box(
        modifier
            .toolingGraphicsLayer()
            .defaultSizeFor(painter)
            .paint(painter, colorFilter = colorFilter, contentScale = ContentScale.Fit)
            .then(semantics)
    )
}

/** Default values for [Icon]s */
object IconDefaults {
    /** Default icon size for [Icon]s with no intrinsic size information. */
    val size: Dp = 24.dp
}

/**
 * Applies the default icon size to a modifier and returns it.
 * @return [Modifier] concatenated with default size if intrinsic size unspecified, original modifier
 * otherwise
 */
private fun Modifier.defaultSizeFor(painter: Painter): Modifier =
    this.then(
        if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
            Modifier.size(IconDefaults.size)
        } else {
            Modifier
        }
    )

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()

@Preview
@Composable
fun FAQIconPreview() {

    Icon(
        painter = painterResource(id = R.drawable.ic_faq),
        contentDescription = null,
        modifier = Modifier
            .size(24.dp)
    )
}

@Preview
@Composable
fun CheckIconPreview() {

    Icon(
        painter = painterResource(id = R.drawable.ic_check),
        contentDescription = null,
    )
}