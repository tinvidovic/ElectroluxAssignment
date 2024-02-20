package com.nticoding.electroluxassignment.domain.model

import androidx.annotation.DrawableRes
import com.nticoding.electroluxassignment.util.UIText
import java.io.Serializable

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
    var selected: Boolean = false
) : Serializable