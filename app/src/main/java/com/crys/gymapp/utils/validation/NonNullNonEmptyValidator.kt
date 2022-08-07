package com.crys.gymapp.utils.validation

object NonNullNonEmptyValidator : FieldValidator {

    override fun validate(fieldValue: String?): ValidationResult =
        if (fieldValue.isNullOrEmpty()) ValidationResult.ValidationFailure(ValidationFailReason.ValueNullOrEmpty)
        else ValidationResult.ValidationSuccess
}