package com.crys.gymapp.feature_weight.domain.use_case

import com.crys.gymapp.feature_weight.domain.model.Weight
import com.crys.gymapp.feature_weight.domain.repository.WeightRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeightsUseCase @Inject constructor(
    private val repository: WeightRepository
) {

    operator fun invoke(): Flow<List<Weight>> {
        return repository.getWeights()
    }
}