package com.nticoding.electroluxassignment.data.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Program(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val iconResId: Int,
)
