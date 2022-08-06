package com.crys.gymapp.feature_weight.domain.use_case

import com.crys.gymapp.feature_weight.domain.model.Weight
import com.crys.gymapp.feature_weight.domain.repository.WeightRepository
import javax.inject.Inject

class GetWeightUseCase @Inject constructor(
    private val repository: WeightRepository
) {

    suspend operator fun invoke(dateOfMeasurement: Long): Weight? {
        return repository.getWeight(dateOfMeasurement)
    }
}