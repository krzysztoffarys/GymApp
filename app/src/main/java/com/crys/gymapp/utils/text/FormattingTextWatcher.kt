package com.crys.gymapp.utils.text

import android.text.Editable
import android.text.TextWatcher

abstract class FormattingTextWatcher : TextWatcher {

    private var isRunning = false

    private var isDeleting = false

    abstract fun formatAfterTextChanged(editable: Editable, isDeleting: Boolean)

    override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
        isDeleting = count > after
    }

    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(editable: Editable) {
        runSafeTextUpdate {
            formatAfterTextChanged(editable, isDeleting)
        }
    }

    private fun runSafeTextUpdate(block: () -> Unit) {
        if (isRunning) {
            return
        }
        isRunning = true
        block()
        isRunning = false
    }

    protected fun Editable.setText(text: CharSequence) {
        clear()
        append(text)
    }
}