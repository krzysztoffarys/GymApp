package com.crys.gymapp.feature_weight.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weight(
    val weightInGrams: Long,
    @PrimaryKey
    val dateOfMeasurement: Long
)
