package com.nticoding.electroluxassignment.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

data class SelectableOption(
    val title: String,
    val description: String,
    @DrawableRes val iconResId: Int,
    val selected: Boolean = false
)