package com.crys.gymapp.utils.validation

interface FieldValidator {
    fun validate(fieldValue: String?): ValidationResult
}