package com.crys.gymapp.feature_weight.data

import androidx.room.*
import com.crys.gymapp.feature_weight.domain.Weight
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightDao {

    @Query("SELECT * FROM weight")
    fun getWeights(): Flow<List<Weight>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeight(weight: Weight)

    @Delete
    suspend fun deleteWeight(weight: Weight)
}