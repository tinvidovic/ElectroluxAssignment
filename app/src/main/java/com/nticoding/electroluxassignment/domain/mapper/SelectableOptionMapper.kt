package com.nticoding.electroluxassignment.domain.mapper

import android.content.Context
import androidx.core.content.ContextCompat.getString
import com.nticoding.electroluxassignment.data.entity.Program
import com.nticoding.electroluxassignment.domain.model.SelectableOption
import com.nticoding.electroluxassignment.util.UIText


/**
 * Maps a [Program] to a [SelectableOption] using the program's resource IDs
 * @param asSelected Boolean, indicating if the mapped result should be selected
 */
fun Program.toSelectableOption(asSelected: Boolean = false): SelectableOption {

    return SelectableOption(
        title = UIText.StringResource(title),
        description = UIText.StringResource(description),
        iconResId = iconResId,
        selected = asSelected
    )
}