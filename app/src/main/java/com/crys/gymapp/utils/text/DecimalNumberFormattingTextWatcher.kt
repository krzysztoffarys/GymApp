package com.crys.gymapp.utils.text

import android.text.Editable

class DecimalNumberFormattingTextWatcher(
    private val textChangeHandler: DecimalNumberFormattingTextChangeHandler
) : FormattingTextWatcher() {

    override fun formatAfterTextChanged(editable: Editable, isDeleting: Boolean) {
        val text = editable.toString()
        val formattedText = textChangeHandler.checkAndAdjustIfNecessary(text)
        if (formattedText != text) {
            editable.setText(formattedText)
        }
    }
}