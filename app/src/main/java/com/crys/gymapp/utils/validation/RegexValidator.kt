package com.crys.gymapp.utils.validation

open class RegexValidator(
    private val regex: Regex,
    private val regexNoMatchFailReason: ValidationFailReason
) : FieldValidator {

    override fun validate(fieldValue: String?): ValidationResult =
        when {
            fieldValue.isNullOrEmpty() -> ValidationResult.ValidationFailure(ValidationFailReason.ValueNullOrEmpty)
            !regex.matches(fieldValue) -> ValidationResult.ValidationFailure(regexNoMatchFailReason)
            else -> ValidationResult.ValidationSuccess
        }
}