package com.crys.gymapp.utils.extensions

import android.widget.Button
import com.crys.gymapp.utils.validation.ValidationResult

fun Button.handleValidationResult(result: ValidationResult) {
    when (result) {
        is ValidationResult.ValidationFailure -> this.disable()
        is ValidationResult.ValidationSuccess -> this.enable()
    }
}