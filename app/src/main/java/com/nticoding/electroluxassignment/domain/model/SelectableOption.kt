package com.nticoding.electroluxassignment.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.nticoding.electroluxassignment.util.UIText

data class SelectableOption(
    val title: UIText,
    val description: UIText,
    @DrawableRes val iconResId: Int,
    val selected: Boolean = false
)