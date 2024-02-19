package com.nticoding.electroluxassignment.util

import android.content.Context

/**
 * A utility class providing a way of using dynamic and string resource strings. The class serves
 * as a bridge between context-less (e.g. ViewModel) environment and the context-full Composables.
 * The Composables provide the local context in order to access and render the strings.
 */
sealed class UIText {
    data class DynamicString(val text: String): UIText()
    data class StringResource(val resId: Int): UIText()

    /**
     * Converts a [UIText] to a [String]
     */
    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId)
        }
    }
}