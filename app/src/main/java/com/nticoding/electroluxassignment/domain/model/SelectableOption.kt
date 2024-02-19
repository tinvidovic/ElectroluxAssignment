package com.nticoding.electroluxassignment.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.nticoding.electroluxassignment.util.UIText

/**
 * A washing machine program
 * @param title title [UIText]
 * @param description description [UIText]
 * @param iconResId drawable resource id of the icon
 * @param selected Boolean indicating if the option is selected
 */
data class SelectableOption(
    val title: UIText,
    val description: UIText,
    @DrawableRes val iconResId: Int,
    val selected: Boolean = false
)