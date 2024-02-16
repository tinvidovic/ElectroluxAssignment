package com.nticoding.electroluxassignment.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Program(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val iconResId: Int,
)
