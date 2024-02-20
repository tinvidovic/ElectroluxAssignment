package com.nticoding.electroluxassignment.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

// List of all used colors and mapping to meaningful names
val white: Color = Color(0xFFFFFFFF)
val whiteSmoke: Color = Color(0xFFF5F5F5)
val quicksilver: Color = Color(0xFFA6A6A6)
val dugong: Color = Color(0xFF707070)
val bauhaus: Color = Color(0xFF404040)
val carbon: Color = Color(0xFF323333)
val direWolf: Color = Color(0xFF272727)
val chaosBlack: Color = Color(0xFF101010)

/**
 * Colors abstraction, implemented by [LightColors] and [DarkColors]
 */
private interface Colors {
    // Background
    val background: Color

    // Containers
    val container: Color

    // Content
    val contentPrimary: Color
    val contentSecondary: Color

    // Dividers
    val divider: Color
}

/**
 * Implementation of default colors used in light mode
 */
private object LightColors : Colors {
    // Background
    override val background = whiteSmoke

    // Containers
    override val container = white

    // Content
    override val contentPrimary = carbon
    override val contentSecondary = dugong

    // Dividers
    override val divider: Color = whiteSmoke
}

/**
 * Implementation of default colors used in light mode
 */
private object DarkColors : Colors {
    // Background
    override val background = chaosBlack

    // Containers
    override val container = direWolf

    // Content
    override val contentPrimary = white
    override val contentSecondary = quicksilver

    override val divider: Color = bauhaus
}

/**
 * A color scheme holds all the named color parameters of a [ElectroluxAssignmentTheme].
 * @property background The background color that appears behind the main content
 * @property container The color of containers, implemented by default by [TODO: list]
 * @property contentPrimary The primary container content color
 * @property contentSecondary The secondary container content color
 */
@Stable
class ColorScheme(
    background: Color,
    container: Color,
    contentPrimary: Color,
    contentSecondary: Color,
    divider: Color,
) : Colors {

    override var background by mutableStateOf(background, structuralEqualityPolicy())
        private set
    override var container by mutableStateOf(container, structuralEqualityPolicy())
        private set
    override var contentPrimary by mutableStateOf(contentPrimary, structuralEqualityPolicy())
        private set
    override var contentSecondary by mutableStateOf(contentSecondary, structuralEqualityPolicy())
        private set

    override var divider by mutableStateOf(divider, structuralEqualityPolicy())
        private set

    /** Returns a copy of this [ColorScheme], optionally overriding some of the values. */
    fun copy(
        background: Color = this.background,
        container: Color = this.container,
        contentPrimary: Color = this.contentPrimary,
        contentSecondary: Color = this.contentSecondary,
        divider: Color = this.divider
    ): ColorScheme =
        ColorScheme(
            background = background,
            container = container,
            contentPrimary = contentPrimary,
            contentSecondary = contentSecondary,
            divider = divider
        )
}

/**
 * Returns a light Electrolux Assignment color scheme.
 */
fun lightColorScheme(
    background: Color = LightColors.background,
    container: Color = LightColors.container,
    contentPrimary: Color = LightColors.contentPrimary,
    contentSecondary: Color = LightColors.contentSecondary,
    divider: Color = LightColors.divider
): ColorScheme =
    ColorScheme(
        background = background,
        container = container,
        contentPrimary = contentPrimary,
        contentSecondary = contentSecondary,
        divider = divider
    )

/**
 * Returns a dark Electrolux Assignment color scheme.
 */
fun darkColorScheme(
    background: Color = DarkColors.background,
    container: Color = DarkColors.container,
    contentPrimary: Color = DarkColors.contentPrimary,
    contentSecondary: Color = DarkColors.contentSecondary,
    divider: Color = DarkColors.divider
): ColorScheme =
    ColorScheme(
        background = background,
        container = container,
        contentPrimary = contentPrimary,
        contentSecondary = contentSecondary,
        divider = divider
    )

/**
 * CompositionLocal used to specify the default typography
 */
internal val LocalColorScheme = staticCompositionLocalOf {
    // Static composition local (colors are not likely to change)
    lightColorScheme()
}

/**
 * A low level of alpha used to represent disabled components, such as content in a disabled
 * [TODO: list].
 */
internal const val DisabledAlpha = 0.4f

