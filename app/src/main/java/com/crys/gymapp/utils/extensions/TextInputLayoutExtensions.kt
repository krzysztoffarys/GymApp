package com.crys.gymapp.utils

import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.core.view.children
import androidx.core.view.updatePadding
import com.crys.gymapp.utils.validation.ValidationResult
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.handleValidationResult(result: ValidationResult) {
    when (result) {
        is ValidationResult.ValidationFailure -> setErrorText(context.getString(result.failReason.messageRes))
        is ValidationResult.ValidationSuccess -> this.clearError()
    }
}

fun TextInputLayout.setErrorText(@StringRes textRes: Int?) {
    setErrorText(textRes?.let(context::getString))
}

fun TextInputLayout.setErrorText(text: CharSequence?) {
    if (text != null) {
        error = text
    }
    isErrorEnabled = text != null
    disableStartPaddingIfErrorIsVisible()
}

fun TextInputLayout.clearError() {
    this.error = null
    this.isErrorEnabled = false
}

fun TextInputLayout.disableStartPaddingIfErrorIsVisible() {
    if (isErrorEnabled) {
        children.filter { it is LinearLayout }.firstOrNull()?.updatePadding(left = 0)
    }
}