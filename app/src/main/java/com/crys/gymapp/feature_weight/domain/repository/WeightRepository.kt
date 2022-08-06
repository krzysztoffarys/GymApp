package com.crys.gymapp.feature_weight.domain.repository

import com.crys.gymapp.feature_weight.domain.model.Weight
import kotlinx.coroutines.flow.Flow

interface WeightRepository {

    fun getWeights(): Flow<List<Weight>>

    suspend fun getWeight(date: Long): Weight?

    suspend fun insertWeight(weight: Weight)

    suspend fun deleteWeight(weight: Weight)
}