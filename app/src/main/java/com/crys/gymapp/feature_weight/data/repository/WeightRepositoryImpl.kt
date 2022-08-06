package com.crys.gymapp.feature_weight.data.repository

import com.crys.gymapp.feature_weight.data.data_source.WeightDao
import com.crys.gymapp.feature_weight.domain.model.Weight
import com.crys.gymapp.feature_weight.domain.repository.WeightRepository
import kotlinx.coroutines.flow.Flow

class WeightRepositoryImpl(
    private val dao: WeightDao
) : WeightRepository {

    override fun getWeights(): Flow<List<Weight>> {
        return dao.getWeights()
    }

    override suspend fun getWeight(date: Long): Weight? {
        return dao.getWeight(date)
    }

    override suspend fun insertWeight(weight: Weight) {
        dao.insertWeight(weight)
    }

    override suspend fun deleteWeight(weight: Weight) {
        dao.deleteWeight(weight)
    }
}