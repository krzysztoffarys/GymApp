package com.crys.gymapp.utils.validation

internal fun validationOf(
    vararg validators: FieldValidator,
    optionalField: Boolean = false
): CompositeFieldValidator = CompositeFieldValidator(validators.toList(), optionalField)

internal class CompositeFieldValidator(
    private val fieldValidators: List<FieldValidator>,
    private val optionalField: Boolean = false
) : FieldValidator {

    override fun validate(fieldValue: String?): ValidationResult {
        if (optionalField && fieldValue.isNullOrEmpty()) return ValidationResult.ValidationSuccess
        for (validator in fieldValidators)
            validator.validate(fieldValue).run {
                if (this is ValidationResult.ValidationFailure) return this
            }
        return ValidationResult.ValidationSuccess
    }
}