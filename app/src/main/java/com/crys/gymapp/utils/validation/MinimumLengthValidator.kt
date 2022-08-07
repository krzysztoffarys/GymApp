package com.crys.gymapp.utils.validation

class MinimumLengthValidator(
    private val minLength: Int,
    private val failReason: ValidationFailReason = ValidationFailReason.ValueTooShort
) : FieldValidator {

    override fun validate(fieldValue: String?): ValidationResult =
        fieldValue?.let {
            if (it.length < minLength) ValidationResult.ValidationFailure(failReason)
            else ValidationResult.ValidationSuccess
        } ?: ValidationResult.ValidationSuccess
}