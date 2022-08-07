package com.crys.gymapp.utils.validation

sealed class ValidationResult {
    object ValidationSuccess : ValidationResult()
    data class ValidationFailure(val failReason: ValidationFailReason) : ValidationResult()
}

internal val ValidationResult?.isSuccess
    get() = this is ValidationResult.ValidationSuccess