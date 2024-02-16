package com.nticoding.electroluxassignment.domain.mapper

import android.content.Context
import androidx.core.content.ContextCompat.getString
import com.nticoding.electroluxassignment.data.entity.Program
import com.nticoding.electroluxassignment.domain.model.SelectableOption


fun Program.toSelectableOption(context: Context, asSelected: Boolean = false): SelectableOption {

    return SelectableOption(
        title = getString(context, title),
        description = getString(context, description),
        iconResId = iconResId,
        selected = asSelected
    )
}