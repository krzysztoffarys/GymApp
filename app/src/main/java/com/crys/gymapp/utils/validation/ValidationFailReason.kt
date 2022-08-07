package com.crys.gymapp.utils.validation

import com.crys.gymapp.R
import com.crys.gymapp.utils.text.StringResource

sealed class ValidationFailReason {

    abstract val messageRes: StringResource

    object ValueTooShort : ValidationFailReason() {
        override val messageRes: StringResource = R.string.validation_value_too_short
    }

    object ValueTooLong : ValidationFailReason() {
        override val messageRes: StringResource = R.string.validation_value_too_long
    }

    object ValueNullOrEmpty : ValidationFailReason() {
        override val messageRes: StringResource = R.string.validation_value_null_or_empty
    }

    data class SpecificError(override val messageRes: StringResource) : ValidationFailReason()
}