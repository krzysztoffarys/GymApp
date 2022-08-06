package com.crys.gymapp.feature_weight.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import com.crys.gymapp.feature_weight.domain.model.Weight
import kotlinx.coroutines.flow.Flow

@Dao
interface WeightDao {

    @Query("SELECT * FROM weight")
    fun getWeights(): Flow<List<Weight>>

    @Query("SELECT * FROM weight WHERE dateOfMeasurement = :date")
    suspend fun getWeight(date: Long): Weight?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeight(weight: Weight)

    @Delete
    suspend fun deleteWeight(weight: Weight)
}