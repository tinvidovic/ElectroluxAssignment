package com.nticoding.electroluxassignment.data.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * A washing machine program
 * @param title string resource id of the title
 * @param description string resource id of the description
 * @param iconResId drawable resource id of the icon
 */
data class Program(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val iconResId: Int,
)
