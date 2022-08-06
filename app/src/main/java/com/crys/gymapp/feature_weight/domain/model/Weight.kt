package com.crys.gymapp.feature_weight.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.Exception

@Entity
data class Weight(
    val weightInGrams: Long,
    @PrimaryKey
    val dateOfMeasurement: Long
)

class InvalidWeightException(message: String) : Exception(message)
