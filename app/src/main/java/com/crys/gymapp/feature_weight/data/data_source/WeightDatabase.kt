package com.crys.gymapp.feature_weight.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crys.gymapp.feature_weight.domain.model.Weight

@Database(
    entities = [Weight::class],
    version = 1
)
abstract class WeightDatabase : RoomDatabase() {

    abstract val weightDao: WeightDao

    companion object {
        const val DATABASE_NAME = "weight_db"
    }
}